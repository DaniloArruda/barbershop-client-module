package barbershop.clientmodule.adapter.repository.model;

import java.time.LocalDateTime;

public class AppointmentRecord {
    public String id;
    public LocalDateTime startAt;
    public LocalDateTime endAt;
    public ClientRecord client;
    public BarberRecord barber;
    public TaskRecord task;
}
