package barbershop.clientmodule.port.usecase.request;

import barbershop.clientmodule.domain.model.Appointment;

public class AppointmentRejectedRequest {
    public final Appointment appointment;

    public AppointmentRejectedRequest(Appointment appointment) {
        this.appointment = appointment;
    }
}
