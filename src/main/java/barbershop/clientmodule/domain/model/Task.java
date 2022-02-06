package barbershop.clientmodule.domain.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

public class Task {
    public final UUID id;
    public final String description;
    public final BigDecimal price;
    public final Duration durationInMinutes;

    public Task(UUID id, String description, BigDecimal price, Duration durationInMinutes) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }

    public Task(UUID id, String description, BigDecimal price, long durationInMinutes) {
        this(id, description, price, Duration.ofMinutes(durationInMinutes));
    }
}
