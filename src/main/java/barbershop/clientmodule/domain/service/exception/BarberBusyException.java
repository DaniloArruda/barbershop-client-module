package barbershop.clientmodule.domain.service.exception;

import java.time.LocalDateTime;

import barbershop.clientmodule.domain.model.Barber;

public class BarberBusyException extends Exception {
    public BarberBusyException(Barber barber, LocalDateTime startAt, LocalDateTime endAt) {
        super("the barber " + barber.name + " is already busy at interval between: " + startAt + " and " + endAt);
    }
}
