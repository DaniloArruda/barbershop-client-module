package barbershop.clientmodule.domain.repository;

import java.time.LocalDateTime;

import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.domain.model.Barber;
import barbershop.clientmodule.domain.model.Client;

public interface AppointmentRepository {
    public void save(Appointment appointment);

    public boolean isBarberBusyDuringThisTime(Barber barber, LocalDateTime startAt, LocalDateTime endAt);

    public boolean isClientBusyDuringThisTime(Client client, LocalDateTime startAt, LocalDateTime endAt);
}
