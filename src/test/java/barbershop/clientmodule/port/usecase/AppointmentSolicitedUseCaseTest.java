package barbershop.clientmodule.port.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;
import barbershop.clientmodule.domain.value_object.Email;
import barbershop.clientmodule.domain.value_object.Name;
import barbershop.clientmodule.port.repository.AppointmentRepository;
import barbershop.clientmodule.port.producer.AppointmentProducer;
import barbershop.clientmodule.port.usecase.request.AppointmentSolicitedRequest;

public class AppointmentSolicitedUseCaseTest {
    private final AppointmentSolicitedUseCase useCase;

    private final AppointmentRepository appointmentRepository;
    private final AppointmentProducer appointmentProducer;

    public AppointmentSolicitedUseCaseTest() {
        this.appointmentRepository = Mockito.mock(AppointmentRepository.class);
        this.appointmentProducer = Mockito.mock(AppointmentProducer.class);

        this.useCase = new AppointmentSolicitedUseCase(appointmentProducer, appointmentRepository);
    }

    @Test
    public void whenAppointmentIsSolicited_thenThisAppointmentIsSavedOnRepositoryAndSendToProducer() {
        var client = new Client(new Name("Danielle", "Oliveira"), new Email("danilo@email.com"));
        var barber = new Barber(new Name("Danilo", "Arruda"));
        var task = new Task(UUID.randomUUID(), "Moicano", BigDecimal.TEN, 20);
        var startAt = LocalDateTime.now();

        var solicitAppointmentRequest = new AppointmentSolicitedRequest(client, task, barber, startAt);

        this.useCase.handle(solicitAppointmentRequest);

        verify(this.appointmentRepository).save(any());
        verify(this.appointmentProducer).solicitAppointment(any());
    }
}
