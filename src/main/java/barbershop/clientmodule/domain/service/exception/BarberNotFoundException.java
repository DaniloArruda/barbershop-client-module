package barbershop.clientmodule.domain.service.exception;

import java.util.UUID;

public class BarberNotFoundException extends Exception {
    public BarberNotFoundException(UUID barberId) {
        super("barber with id " + barberId + " not found");
    }
}
