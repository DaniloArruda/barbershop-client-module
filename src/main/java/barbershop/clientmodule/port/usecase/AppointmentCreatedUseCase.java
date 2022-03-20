package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.mailer.Mailer;
import barbershop.clientmodule.port.repository.AppointmentRepository;
import barbershop.clientmodule.port.usecase.request.AppointmentCreatedRequest;

public class AppointmentCreatedUseCase implements UseCase<AppointmentCreatedRequest, Void> {

    private final AppointmentRepository appointmentRepository;
    private final Mailer mailer;

    public AppointmentCreatedUseCase(AppointmentRepository appointmentRepository, Mailer mailer) {
        this.appointmentRepository = appointmentRepository;
        this.mailer = mailer;
    }

    @Override
    public Void handle(AppointmentCreatedRequest request) {
        this.appointmentRepository.save(request.appointment);
        this.mailer.send(request.appointment.client.email.toString(), "Your appointment was confirmed!");

        return null;
    }

}
