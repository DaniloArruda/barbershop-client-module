package barbershop.clientmodule.adapter.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import barbershop.clientmodule.adapter.producer.event.AppointmentSolicited;
import barbershop.clientmodule.domain.model.Appointment;
import barbershop.clientmodule.port.producer.AppointmentProducer;

@Component
public class AppointmentProducerKafka implements AppointmentProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void solicitAppointment(Appointment appointment) {
        var appointmentSolicited = new AppointmentSolicited(appointment);

        kafkaTemplate.send("appointment.solicited", "client-module", appointmentSolicited);
    }

}
