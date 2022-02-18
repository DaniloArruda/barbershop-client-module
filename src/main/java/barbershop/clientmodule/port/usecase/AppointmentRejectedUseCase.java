package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.cache.AppointmentCache;
import barbershop.clientmodule.port.usecase.request.AppointmentRejectedRequest;

public class AppointmentRejectedUseCase implements UseCase<AppointmentRejectedRequest, Void> {

    private final AppointmentCache appointmentCache;

    public AppointmentRejectedUseCase(AppointmentCache appointmentCache) {
        this.appointmentCache = appointmentCache;
    }

    @Override
    public Void handle(AppointmentRejectedRequest request) {
        this.appointmentCache.delete(request.appointment.id);

        return null;
    }

}
