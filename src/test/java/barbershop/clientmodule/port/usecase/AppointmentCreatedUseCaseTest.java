package barbershop.clientmodule.port.usecase;

import static org.mockito.ArgumentMatchers.any;
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
import barbershop.clientmodule.port.cache.AppointmentCache;
import barbershop.clientmodule.port.mailer.Mailer;
import barbershop.clientmodule.port.usecase.request.AppointmentCreatedRequest;

public class AppointmentCreatedUseCaseTest {
    private final AppointmentCreatedUseCase useCase;

    private final AppointmentCache appointmentCache;
    private final Mailer mailer;

    public AppointmentCreatedUseCaseTest() {
        this.appointmentCache = Mockito.mock(AppointmentCache.class);
        this.mailer = Mockito.mock(Mailer.class);

        this.useCase = new AppointmentCreatedUseCase(this.appointmentCache, this.mailer);
    }

    @Test
    public void whenAppointmentIsCreated_thenItIsUpdatedOnCacheAndSendEmailToClient() {
        var client = new Client(new Name("Danielle", "Oliveira"), new Email("danilo@email.com"));
        var barber = new Barber(new Name("Danilo", "Arruda"));
        var task = new Task(UUID.randomUUID(), "Moicano", BigDecimal.TEN, 20);
        var request = new AppointmentCreatedRequest(new Appointment(LocalDateTime.now(), client, barber, task));

        this.useCase.handle(request);

        verify(appointmentCache).save(eq(request.appointment));
        verify(mailer).send(eq(client.email.toString()), any());
    }
}
