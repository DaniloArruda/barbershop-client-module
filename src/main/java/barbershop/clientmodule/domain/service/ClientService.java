package barbershop.clientmodule.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;
import barbershop.clientmodule.port.cache.AppointmentCache;
import barbershop.clientmodule.port.producer.AppointmentProducer;

@Service
public class ClientService {
    private final AppointmentProducer appointmentProducer;
    private final AppointmentCache appointmentCache;

    public ClientService(AppointmentProducer appointmentProducer, AppointmentCache appointmentCache) {
        this.appointmentProducer = appointmentProducer;
        this.appointmentCache = appointmentCache;
    }

    public void solicitAppointment(Client client, Task task, Barber barber, LocalDateTime startAt) throws Exception {
        var appointment = client.schedule(task).with(barber).startingAt(startAt).build();

        this.appointmentCache.save(appointment);

        this.appointmentProducer.requestAppointment(appointment);
    }

    public void refuseAppointment(Appointment appointment) {
        this.appointmentCache.delete(appointment.id);

    }

}
