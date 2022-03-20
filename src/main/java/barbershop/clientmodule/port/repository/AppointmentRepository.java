package barbershop.clientmodule.port.repository;

import java.util.List;
import java.util.UUID;

import barbershop.clientmodule.domain.model.Appointment;

public interface AppointmentRepository {
    public void save(Appointment appointment);

    public List<Appointment> findAppointments(UUID clientId);

    public void delete(UUID appointmentId);
}
