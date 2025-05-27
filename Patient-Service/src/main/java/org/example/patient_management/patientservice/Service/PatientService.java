package org.example.patient_management.patientservice.Service;


import org.example.patient_management.patientservice.DTO.PatientRequestDTO;
import org.example.patient_management.patientservice.DTO.PatientResponseDTO;
import org.example.patient_management.patientservice.Exception.EmailAlreadyExitException;
import org.example.patient_management.patientservice.Exception.PatientNotFoundException;
import org.example.patient_management.patientservice.Models.Patient;
import org.example.patient_management.patientservice.Repository.PatientRepository;
import org.example.patient_management.patientservice.mapper.PatientMapper;
import java.util.UUID;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

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