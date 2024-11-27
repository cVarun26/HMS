package com.example.HealthcareManagement.controller;

import com.example.HealthcareManagement.model.Doctor;
import com.example.HealthcareManagement.repository.DoctorRepo;
import com.example.HealthcareManagement.repository.DoctorSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {


    @Autowired
    DoctorRepo repo;

    @Autowired
    DoctorSearchRepo doctorSearchRepo;




    @GetMapping("/allDoctors")
    public List<Doctor> getAllDoctors(){
       return repo.findAll();
    }



    @GetMapping("/search/{text}")
    public List<Doctor>searchDoctor(@PathVariable String text){
        return doctorSearchRepo.findByText(text);
    }


}
