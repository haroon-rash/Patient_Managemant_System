package org.example.patient_management.patientservice.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.patient_management.patientservice.Validators.ICreatePatientValidationGroup;

@Data
public class PatientRequestDTO {

    @NotBlank(message = "Name is Required")

    @Size(max = 100, message = "Name never exceed 100 character")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email
    private String email;
    @NotBlank(message = "Address is Required")
    private String address;
    @NotBlank(message = "Phone is Required")
    private String phone;

    @NotNull(message = "Date of Birth is Required")
    private String dateOfBirth;
    //this is only specifics for only ICreateValidationGroup class and its  use in controller
    @NotBlank(groups = ICreatePatientValidationGroup.class, message = "Registered Date is Required" )
    private String registeredDate;

}
