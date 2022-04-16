package barbershop.clientmodule.adapter.api.resource;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AppointmentSolicitedResource {
    public ClientResource client;
    public TaskResource task;
    public BarberResource barber;
    public LocalDateTime startAt;

    public static class ClientResource {
        public String id;
        public String firstName;
        public String lastName;
        public String email;
    }

    public static class BarberResource {
        public String id;
        public String firstName;
        public String lastName;
    }

    public static class TaskResource {
        public String id;
        public String description;
        public BigDecimal price;
        public Long durationInMinutes;
    }

}
