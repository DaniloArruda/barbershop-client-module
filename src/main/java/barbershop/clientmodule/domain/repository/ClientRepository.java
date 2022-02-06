package barbershop.clientmodule.domain.repository;

import java.util.Optional;
import java.util.UUID;

import barbershop.clientmodule.domain.model.Client;

public interface ClientRepository {
    public Optional<Client> findById(UUID id) throws Exception;
}
