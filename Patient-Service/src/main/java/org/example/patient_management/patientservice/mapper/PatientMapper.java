package org.example.patient_management.patientservice.mapper;


import org.example.patient_management.patientservice.DTO.PatientRequestDTO;
import org.example.patient_management.patientservice.DTO.PatientResponseDTO;
import org.example.patient_management.patientservice.Models.Patient;

import java.time.LocalDate;

public class PatientMapper {

    //Map patient  to patient Response DTO object

    //converts patient to patientResponseDTo
    public static PatientResponseDTO mapToPatientResponseDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setPhone(patient.getPhone());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientDTO.setRegisteredDate(patient.getRegisteredDate().toString());

        return patientDTO;
    }

    //convert PatientRequestDTo to Patient
public static Patient mapToPatient(PatientRequestDTO patientRequestDTO){
    Patient patient = new Patient();
    patient.setName(patientRequestDTO.getName());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setPhone(patientRequestDTO.getPhone());
    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
    patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
}


}
