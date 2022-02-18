package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.cache.AppointmentCache;
import barbershop.clientmodule.port.producer.AppointmentProducer;
import barbershop.clientmodule.port.usecase.request.AppointmentSolicitRequest;

public class AppointmentSolicitedUseCase implements UseCase<AppointmentSolicitRequest, Void> {

    private final AppointmentProducer appointmentProducer;
    private final AppointmentCache appointmentCache;

    public AppointmentSolicitedUseCase(AppointmentProducer appointmentProducer, AppointmentCache appointmentCache) {
        this.appointmentProducer = appointmentProducer;
        this.appointmentCache = appointmentCache;
    }

    @Override
    public Void handle(AppointmentSolicitRequest request) {
        var appointment = request.client
                .schedule(request.task)
                .with(request.barber)
                .startingAt(request.startAt)
                .build();

        this.appointmentCache.save(appointment);

        this.appointmentProducer.solicitAppointment(appointment);

        return null;
    }

}
