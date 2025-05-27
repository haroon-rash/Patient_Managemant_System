package org.example.patient_management.patientservice.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    @Email
    private String email;
    @NotNull
    private String address;
    @Column(nullable = true)
    private String phone;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private LocalDate registeredDate;


}
