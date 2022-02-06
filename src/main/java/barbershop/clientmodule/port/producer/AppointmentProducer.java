package barbershop.clientmodule.port.producer;

import barbershop.clientmodule.domain.model.Appointment;

public interface AppointmentProducer {
    void requestAppointment(Appointment appointment);
}
