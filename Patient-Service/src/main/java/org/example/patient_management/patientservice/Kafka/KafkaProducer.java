package org.example.patient_management.patientservice.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.patient_management.patientservice.Models.Patient;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Slf4j
@Service
public class KafkaProducer {

   private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }



public void sendEvent(Patient patient) {

    PatientEvent event=PatientEvent.newBuilder().setPatientId(patient.getId().toString())
            .setName(patient.getName())
            .setEmail(patient.getEmail())
            .setEventType("Patient Created").build();


    //send messages

    try{
        this.kafkaTemplate.send("patient-events", event.toByteArray());
    }catch (Exception e){
        log.error("Error in sending  messages : {} ",event);
    }

}

}
