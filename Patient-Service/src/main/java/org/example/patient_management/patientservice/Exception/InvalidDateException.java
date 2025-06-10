package org.example.patient_management.patientservice.Exception;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String message) {
        super(message);
    }
}
