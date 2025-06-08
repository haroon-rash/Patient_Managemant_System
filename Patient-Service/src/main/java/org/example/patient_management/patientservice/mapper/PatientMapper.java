package org.example.patient_management.patientservice.mapper;

import org.example.patient_management.patientservice.DTO.PatientRequestDTO;
import org.example.patient_management.patientservice.DTO.PatientResponseDTO;
import org.example.patient_management.patientservice.Models.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PatientMapper {

    // Map Patient -> PatientResponseDTO
    public static PatientResponseDTO mapToPatientResponseDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId().toString());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setPhone(patient.getPhone());
        dto.setDateOfBirth(patient.getDateOfBirth().toString());
        dto.setRegisteredDate(patient.getRegisteredDate().toString());
        return dto;
    }

    // Map PatientRequestDTO -> Patient
    public static Patient mapToPatient(PatientRequestDTO requestDTO) {
        Patient patient = new Patient();
        patient.setName(requestDTO.getName());
        patient.setEmail(requestDTO.getEmail());
        patient.setAddress(requestDTO.getAddress());
        patient.setPhone(requestDTO.getPhone());

        // Safe Date Parsing with error handling
        try {
            patient.setDateOfBirth(LocalDate.parse(requestDTO.getDateOfBirth())); // Format: yyyy-MM-dd
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for dateOfBirth: " + requestDTO.getDateOfBirth());
        }

        try {
            patient.setRegisteredDate(LocalDate.parse(requestDTO.getRegisteredDate())); // Format: yyyy-MM-dd
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for registeredDate: " + requestDTO.getRegisteredDate());
        }

        return patient;
    }
}
