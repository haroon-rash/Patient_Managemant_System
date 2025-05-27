package org.example.patient_management.patientservice.ApiErrors;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiErrorResponse {
    private int errorCode;
    private String errorMessage;
    private LocalDate timestamp;

   
}
