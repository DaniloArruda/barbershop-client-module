package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.repository.AppointmentRepository;
import barbershop.clientmodule.port.usecase.request.AppointmentRejectedRequest;

public class AppointmentRejectedUseCase implements UseCase<AppointmentRejectedRequest, Void> {

    private final AppointmentRepository appointmentRepository;

    public AppointmentRejectedUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Void handle(AppointmentRejectedRequest request) {
        this.appointmentRepository.delete(request.appointment.id);

        return null;
    }

}
