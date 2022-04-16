package barbershop.clientmodule.adapter.repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import barbershop.clientmodule.adapter.repository.model.AppointmentRecord;
import barbershop.clientmodule.adapter.repository.model.BarberRecord;
import barbershop.clientmodule.adapter.repository.model.ClientRecord;
import barbershop.clientmodule.adapter.repository.model.TaskRecord;
import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;
import barbershop.clientmodule.port.repository.AppointmentRepository;

@Repository
public class AppointmentRepositoryMongo implements AppointmentRepository {

    @Autowired
    private MongoManager mongoDb;

    @Override
    public void save(Appointment appointment) {
        var appointmentRecord = appointmentEntityToRecord(appointment);
        var clientId = appointment.client.id.toString();

        var clientRecord = mongoDb
                .findById(clientId)
                .orElse(newClientRecord(clientId));

        clientRecord.appointments.add(appointmentRecord);

        mongoDb.save(clientRecord);
    }

    private ClientRecord newClientRecord(String clientId) {
        var clientRecord = new ClientRecord();
        clientRecord.id = clientId;
        return clientRecord;
    }

    @Override
    public List<Appointment> findAppointments(UUID clientId) {
        ClientRecord clientRecord = mongoDb.findById(clientId.toString())
                .orElseThrow(() -> new RuntimeException("Client with id " + clientId + " does not exist."));

        return clientRecord.appointments
                .stream()
                .map(record -> this.appointmentEntityFromRecord(record))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(UUID appointmentId) {
        // TODO Auto-generated method stub

    }

    private Appointment appointmentEntityFromRecord(AppointmentRecord record) {
        return new Appointment(
                UUID.fromString(record.id),
                record.startAt,
                clientEntityFromRecord(record.client),
                barberEntityFromRecord(record.barber),
                taskEntityFromRecord(record.task));
    }

    private Task taskEntityFromRecord(TaskRecord task) {
        return null;
    }

    private Barber barberEntityFromRecord(BarberRecord barber) {
        return null;
    }

    private Client clientEntityFromRecord(ClientRecord client) {
        return null;
    }

    private AppointmentRecord appointmentEntityToRecord(Appointment appointment) {
        var record = new AppointmentRecord();

        record.id = appointment.id.toString();
        record.startAt = appointment.startAt;
        record.client = clientEntityToRecord(appointment.client);
        record.barber = barberEntityToRecord(appointment.barber);
        record.task = taskEntityToRecord(appointment.task);
        record.endAt = appointment.endAt;

        return record;
    }

    private TaskRecord taskEntityToRecord(Task task) {
        return new TaskRecord();
    }

    private BarberRecord barberEntityToRecord(Barber barber) {
        return new BarberRecord();
    }

    private ClientRecord clientEntityToRecord(Client client) {
        return new ClientRecord();
    }

}
