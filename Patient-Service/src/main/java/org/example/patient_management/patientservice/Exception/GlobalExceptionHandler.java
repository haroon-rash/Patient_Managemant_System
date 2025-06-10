package org.example.patient_management.patientservice.Exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle Bean Validation errors (e.g. @NotBlank, @Email, etc.)
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
*/
    //  Handle validation groups using @Validated
/*    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolations(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String field = violation.getPropertyPath().toString();
            errors.put(field, violation.getMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }*/

    //  Handle existing email
    @ExceptionHandler(EmailAlreadyExitException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(EmailAlreadyExitException ex) {
        log.warn("Email already exists: {}", ex.getMessage());
        Map<String, String> error = new HashMap<>();
        error.put("message", "Email already exists");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    //  Handle patient not found
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFound(PatientNotFoundException ex) {
        log.warn("Patient not found: {}", ex.getMessage());
        Map<String, String> error = new HashMap<>();
        error.put("message", "Patient not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    //  Handle invalid JSON (date format, enum parsing, etc.)
    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<Map<String, String>> handleInvalidDateException(InvalidDateException ex) {
        log.warn("Invalid date Found: {}", ex.getMessage());
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    //  Fallback for any unexpected exceptions



}
