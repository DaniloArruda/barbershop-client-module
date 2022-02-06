package barbershop.clientmodule.domain.repository;

import java.util.Optional;
import java.util.UUID;

import barbershop.clientmodule.domain.model.Task;

public interface TaskRepository {
    public Optional<Task> findById(UUID id) throws Exception;
}
