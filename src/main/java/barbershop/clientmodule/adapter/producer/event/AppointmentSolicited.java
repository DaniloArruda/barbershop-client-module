package barbershop.clientmodule.adapter.producer.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;

public class AppointmentSolicited {
    public final String id;
    public final LocalDateTime startAt;
    public final ClientRecord client;
    public final BarberRecord barber;
    public final TaskRecord task;

    public AppointmentSolicited(Appointment appointment) {
        this.id = appointment.id.toString();
        this.startAt = appointment.startAt;
        this.client = new ClientRecord(appointment.client);
        this.barber = new BarberRecord(appointment.barber);
        this.task = new TaskRecord(appointment.task);
    }

    public static class ClientRecord {
        public final String id;
        public final String firstName;
        public final String lastName;
        public final String email;

        public ClientRecord(Client client) {
            this.id = client.id.toString();
            this.firstName = client.name.firstName;
            this.lastName = client.name.lastName;
            this.email = client.email.toString();
        }
    }

    public static class BarberRecord {
        public final String id;
        public final String firstName;
        public final String lastName;

        public BarberRecord(Barber barber) {
            this.id = barber.id.toString();
            this.firstName = barber.name.firstName;
            this.lastName = barber.name.lastName;
        }
    }

    public static class TaskRecord {
        public final String id;
        public final String description;
        public final BigDecimal price;
        public final Long durationInMinutes;

        public TaskRecord(Task task) {
            this.id = task.id.toString();
            this.description = task.description;
            this.price = task.price;
            this.durationInMinutes = task.duration.toMinutes();
        }
    }
}
