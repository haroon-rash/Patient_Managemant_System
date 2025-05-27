package org.example.patient_management.patientservice.Controller;


import jakarta.validation.groups.Default;
import org.example.patient_management.patientservice.ApiErrors.ApiErrorResponse;
import org.example.patient_management.patientservice.DTO.PatientRequestDTO;
import org.example.patient_management.patientservice.DTO.PatientResponseDTO;
import org.example.patient_management.patientservice.Service.PatientService;
import org.example.patient_management.patientservice.Validators.ICreatePatientValidationGroup;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")  // http://localhost:4000/patient
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

     @GetMapping("/getpatient")
    public ResponseEntity<?> getpatients(){
        List<PatientResponseDTO> patientResponseDTOs = patientService.getpatients();
        if(patientResponseDTOs.isEmpty()){
            ApiErrorResponse errorResponse = new ApiErrorResponse(404, "No patients found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.ok(patientResponseDTOs);
     }

     @PostMapping("createpatient")
public ResponseEntity<PatientResponseDTO> createpatient(
        //this is  specific withdefault all entity and also ICreateValidationGroup entitiy which  is specifies only for
        //this class ie  registered_date
        @Validated({Default.class, ICreatePatientValidationGroup.class})
        @RequestBody PatientRequestDTO patientRequest){
         PatientResponseDTO patientResponseDTO = patientService.createpatient(patientRequest);
         return ResponseEntity.ok(patientResponseDTO);


     }
// @Validated(Default.class) only validated  that appear on PatientRequestDTO
     @PutMapping("updatepatient/{id}")
    public ResponseEntity<?> updatepatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequest){

PatientResponseDTO patientResponseDTO=patientService.updatepatient(id,patientRequest);

return ResponseEntity.ok(patientResponseDTO);
     }


    @DeleteMapping("deletepatient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }





}
