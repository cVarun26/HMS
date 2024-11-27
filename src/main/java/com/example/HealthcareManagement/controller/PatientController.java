package com.example.HealthcareManagement.controller;

import com.example.HealthcareManagement.model.Patient;
import com.example.HealthcareManagement.repository.PatientRepo;
import com.example.HealthcareManagement.repository.PatientSearchRepo;
import com.example.HealthcareManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
