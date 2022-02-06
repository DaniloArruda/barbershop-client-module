package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.cache.AppointmentCache;
import barbershop.clientmodule.port.mailer.Mailer;
import barbershop.clientmodule.port.usecase.request.AppointmentCreatedRequest;

public class AppointmentCreatedUseCase implements UseCase<AppointmentCreatedRequest, Void> {

    private final AppointmentCache appointmentCache;
    private final Mailer mailer;

    public AppointmentCreatedUseCase(AppointmentCache appointmentCache, Mailer mailer) {
        this.appointmentCache = appointmentCache;
        this.mailer = mailer;
    }

    @Override
    public Void perform(AppointmentCreatedRequest request) {
        this.appointmentCache.save(request.appointment);
        this.mailer.send(request.appointment.client.email.toString(), "Your appointment was confirmed!");

        return null;
    }

}
