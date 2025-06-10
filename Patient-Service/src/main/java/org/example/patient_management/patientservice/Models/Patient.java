package org.example.patient_management.patientservice.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Email  is required")
    @Column(unique = true)
    @Email
    private String email;
    @NotNull(message = "Address is requird")
    private String address;
    @Column(nullable = true)
    private String phone;

    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Date never exceeded the current date")
    private LocalDate dateOfBirth;
    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Date never exceeded the current date")
    private LocalDate registeredDate;


}
