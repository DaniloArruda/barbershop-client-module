package barbershop.clientmodule.adapter.api;

import java.time.Duration;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barbershop.clientmodule.adapter.api.resource.AppointmentSolicitedResource;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;
import barbershop.clientmodule.domain.model.Task;
import barbershop.clientmodule.domain.value_object.Email;
import barbershop.clientmodule.domain.value_object.Name;
import barbershop.clientmodule.port.usecase.AppointmentSolicitedUseCase;
import barbershop.clientmodule.port.usecase.request.AppointmentSolicitedRequest;

@RestController
@RequestMapping(path = "/api")
public class ClientController {

    @Autowired
    private AppointmentSolicitedUseCase appointmentSolicitedUseCase;

    @PostMapping(path = "/solicit-appointment")
    public ResponseEntity<Object> solicitAppointment(@RequestBody AppointmentSolicitedResource payload) {
        var request = this.convertToRequest(payload);

        appointmentSolicitedUseCase.handle(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private AppointmentSolicitedRequest convertToRequest(AppointmentSolicitedResource payload) {
        return new AppointmentSolicitedRequest(
                new Client(UUID.fromString(payload.client.id),
                        new Name(payload.client.firstName, payload.client.lastName), new Email(payload.client.email)),
                new Task(UUID.fromString(payload.task.id), payload.task.description, payload.task.price,
                        Duration.ofMinutes(payload.task.durationInMinutes)),
                new Barber(UUID.fromString(payload.barber.id),
                        new Name(payload.barber.firstName, payload.barber.lastName)),
                payload.startAt);
    }
}
