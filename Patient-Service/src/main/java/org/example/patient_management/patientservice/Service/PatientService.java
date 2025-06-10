package org.example.patient_management.patientservice.Service;


import org.example.patient_management.patientservice.DTO.PatientRequestDTO;
import org.example.patient_management.patientservice.DTO.PatientResponseDTO;
import org.example.patient_management.patientservice.Exception.EmailAlreadyExitException;
import org.example.patient_management.patientservice.Exception.InvalidDateException;
import org.example.patient_management.patientservice.Exception.PatientNotFoundException;
import org.example.patient_management.patientservice.Grpc.BillingServiceGrpcClient;
import org.example.patient_management.patientservice.Kafka.KafkaProducer;
import org.example.patient_management.patientservice.Models.Patient;
import org.example.patient_management.patientservice.Repository.PatientRepository;
import org.example.patient_management.patientservice.mapper.PatientMapper;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {


    // Example of validation method:







    private PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
private final KafkaProducer  kafkaProducer;
    public PatientService(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient, KafkaProducer kafkaProducer) {

        this.patientRepository = patientRepository;
this.billingServiceGrpcClient = billingServiceGrpcClient;
this.kafkaProducer = kafkaProducer;
    }


    public List<PatientResponseDTO> getpatients() {
        List<Patient> patients = patientRepository.findAll();


        List<PatientResponseDTO> patientResponseDTOs = patients.stream()
                .map(PatientMapper::mapToPatientResponseDTO).toList();

        return patientResponseDTOs;

    }
// Email Validation



    public PatientResponseDTO createpatient(PatientRequestDTO patientRequestDTO) {


        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExitException("Email already exists : " + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(PatientMapper.mapToPatient(patientRequestDTO));

//send messages via GRPC
billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(),newPatient.getName(),newPatient.getEmail());

//send messages Via Kafka
kafkaProducer.sendEvent(newPatient);


        return PatientMapper.mapToPatientResponseDTO(newPatient);
    }

    public PatientResponseDTO updatepatient(UUID id, PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient Not Found at id : "+id));
        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)) {
            throw new EmailAlreadyExitException("Email already exists : " + patientRequestDTO.getEmail());
        }
patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setPhone(patientRequestDTO.getPhone());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth().toString()));

       Patient updatedpatient= patientRepository.save(patient);
       return PatientMapper.mapToPatientResponseDTO(updatedpatient);
    }


    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }

}