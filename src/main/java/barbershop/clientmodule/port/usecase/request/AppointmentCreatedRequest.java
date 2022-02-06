package barbershop.clientmodule.port.usecase.request;

import barbershop.clientmodule.domain.model.Appointment;

public class AppointmentCreatedRequest {
    public final Appointment appointment;

    public AppointmentCreatedRequest(Appointment appointment) {
        this.appointment = appointment;
    }
}
