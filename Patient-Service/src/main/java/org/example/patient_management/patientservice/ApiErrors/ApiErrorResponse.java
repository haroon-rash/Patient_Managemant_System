package org.example.patient_management.patientservice.ApiErrors;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiErrorResponse {
    private int errorCode;
    private String errorMessage;
    private LocalDate timestamp;

    public ApiErrorResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDate.now();
    }

    public ApiErrorResponse(int errorCode, String errorMessage, LocalDate timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }
}
