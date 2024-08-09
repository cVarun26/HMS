package com.example.HealthcareManagement.Controllers;

import com.example.HealthcareManagement.Models.Patient;
import com.example.HealthcareManagement.Repositories.PatientRepo;
import com.example.HealthcareManagement.Repositories.PatientSearchRepo;
import com.example.HealthcareManagement.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableWebSecurity
@RequestMapping("/Patient")
public class PatientController {

    @Autowired
    PatientRepo repo;

    @Autowired
    PatientSearchRepo searchRepo;

    @Autowired
    PatientService patientService;

    @GetMapping("/allPatients")
    public List<Patient> getAllPatients(){
        return repo.findAll();
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return repo.save(patient);
    }

    @GetMapping("/allPatients/{text}")
    public List<Patient>searchByNameOrID(@PathVariable String text){
        return searchRepo.findByText(text);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatientByID(@PathVariable String id){
        repo.deleteById(id);
    }

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id,@RequestBody Patient patientDetails){

       Patient updatedPatient=patientService.updatePatient(id,patientDetails);


       return ResponseEntity.ok(updatedPatient);


    }



}
