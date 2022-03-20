package barbershop.clientmodule.port.usecase;

import barbershop.clientmodule.port.repository.AppointmentRepository;
import barbershop.clientmodule.port.producer.AppointmentProducer;
import barbershop.clientmodule.port.usecase.request.AppointmentSolicitRequest;

public class AppointmentSolicitedUseCase implements UseCase<AppointmentSolicitRequest, Void> {

    private final AppointmentProducer appointmentProducer;
    private final AppointmentRepository appointmentRepository;

    public AppointmentSolicitedUseCase(AppointmentProducer appointmentProducer,
            AppointmentRepository appointmentRepository) {
        this.appointmentProducer = appointmentProducer;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Void handle(AppointmentSolicitRequest request) {
        var appointment = request.client
                .schedule(request.task)
                .with(request.barber)
                .startingAt(request.startAt)
                .build();

        this.appointmentRepository.save(appointment);

        this.appointmentProducer.solicitAppointment(appointment);

        return null;
    }

}
