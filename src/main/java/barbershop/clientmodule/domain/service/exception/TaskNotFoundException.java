package barbershop.clientmodule.domain.service.exception;

import java.util.UUID;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(UUID taskId) {
        super("task with id " + taskId + " not found");
    }
}
