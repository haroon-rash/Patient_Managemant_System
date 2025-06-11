package org.example.analyticsservice.Kafka;


import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient-events",groupId = "analytics-service")
    public void consumeMessage(byte[] event) {

        try {
            PatientEvent events=PatientEvent.parseFrom(event);
            log.info("Received Patient Event: [ PatientId : {} , PatientName : {} , PatientEmail : {} ]", events.getPatientId().toString(),events.getName(),events.getEmail());
        }catch (InvalidProtocolBufferException e){
            log.error("Error in Deserializing Events {} ",e.getMessage());
        }


    }

}
