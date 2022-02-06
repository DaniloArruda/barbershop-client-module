package barbershop.clientmodule.domain.repository;

import java.util.Optional;
import java.util.UUID;

import barbershop.clientmodule.domain.model.Barber;

public interface BarberRepository {
    public Optional<Barber> findById(UUID id) throws Exception;
}
