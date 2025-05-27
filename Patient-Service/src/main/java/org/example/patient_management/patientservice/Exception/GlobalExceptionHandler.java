package org.example.patient_management.patientservice.Exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //Arguments validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();


        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);

    }

//Email Already Exist Handler
    @ExceptionHandler(EmailAlreadyExitException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExitException(EmailAlreadyExitException ex) {
        log.warn("Email already exists:  {}", ex.getMessage()); //TO Find Bug is Project

        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email already exists");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
        //Patient Not Found HAndler
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotFoundException(PatientNotFoundException ex){
        log.warn("Patient not found: {}",ex.getMessage());
        Map<String,String> errors = new HashMap<>();
        errors.put("message","Patient not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

    }


}