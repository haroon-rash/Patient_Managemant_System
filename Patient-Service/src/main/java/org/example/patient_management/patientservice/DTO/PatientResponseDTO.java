package org.example.patient_management.patientservice.DTO;

import lombok.Data;

@Data
public class PatientResponseDTO {

    public String id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String dateOfBirth;
    private String registeredDate;


}
