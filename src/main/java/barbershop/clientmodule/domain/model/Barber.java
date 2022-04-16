package barbershop.clientmodule.domain.model;

import java.util.UUID;

import barbershop.clientmodule.domain.value_object.Name;

public class Barber {
    public final UUID id;
    public final Name name;

    public Barber(Name name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Barber(UUID id, Name name) {
        this.id = id;
        this.name = name;
    }
}
