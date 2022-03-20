package barbershop.clientmodule.domain.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    public final UUID id;
    public final LocalDateTime startAt;
    public final Client client;
    public final Barber barber;
    public final Task task;

    // computed properties
    public final LocalDateTime endAt;
    public final Duration duration;

    public Appointment(LocalDateTime startAt, Client client, Barber barber, Task task) {
        this.id = UUID.randomUUID();
        this.startAt = startAt;
        this.client = client;
        this.barber = barber;
        this.task = task;

        this.duration = task.duration;
        this.endAt = this.startAt.plus(this.task.duration);
    }

    public Appointment(UUID id, LocalDateTime startAt, Client client, Barber barber, Task task) {
        this.id = id;
        this.startAt = startAt;
        this.client = client;
        this.barber = barber;
        this.task = task;

        this.duration = task.duration;
        this.endAt = this.startAt.plus(this.task.duration);
    }

}
