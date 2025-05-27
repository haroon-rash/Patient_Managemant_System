package org.example.patient_management.patientservice.Repository;


import org.example.patient_management.patientservice.Models.Patient;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, UUID id);

}
