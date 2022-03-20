package barbershop.clientmodule.port.usecase;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;
import barbershop.clientmodule.domain.value_object.Email;
import barbershop.clientmodule.domain.value_object.Name;
import barbershop.clientmodule.port.repository.AppointmentRepository;
import barbershop.clientmodule.port.usecase.request.AppointmentRejectedRequest;

public class AppointmentRejectedUseCaseTest {
    private final AppointmentRejectedUseCase useCase;

    private final AppointmentRepository appointmentRepository;

    public AppointmentRejectedUseCaseTest() {
        this.appointmentRepository = Mockito.mock(AppointmentRepository.class);

        this.useCase = new AppointmentRejectedUseCase(this.appointmentRepository);
    }

    @Test
    public void whenAppointmentIsRejected_thenItIsRemovedFromRepository() {
        var client = new Client(new Name("Danielle", "Oliveira"), new Email("danilo@email.com"));
        var barber = new Barber(new Name("Danilo", "Arruda"));
        var task = new Task(UUID.randomUUID(), "Moicano", BigDecimal.TEN, 20);

        var request = new AppointmentRejectedRequest(new Appointment(LocalDateTime.now(), client, barber, task));

        this.useCase.handle(request);

        verify(appointmentRepository).delete(eq(request.appointment.id));
    }
}
