package barbershop.clientmodule.port.usecase.request;

import java.time.LocalDateTime;

import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;

public class AppointmentSolicitedRequest {
    public final Client client;
    public final Task task;
    public final Barber barber;
    public final LocalDateTime startAt;

    public AppointmentSolicitedRequest(Client client, Task task, Barber barber, LocalDateTime startAt) {
        this.client = client;
        this.task = task;
        this.barber = barber;
        this.startAt = startAt;
    }
}
