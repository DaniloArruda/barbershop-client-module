package barbershop.clientmodule.port.cache;

import java.util.List;
import java.util.UUID;

import barbershop.clientmodule.domain.model.Appointment;

public interface AppointmentCache {
    public void save(Appointment appointment);

    public List<Appointment> listBy(UUID clientId);

    public void delete(UUID appointmentId);
}
