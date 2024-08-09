package com.example.HealthcareManagement.Repositories;

import com.example.HealthcareManagement.Models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepo extends MongoRepository<Doctor,String> {

    List<Doctor> findByDoctorNameAndVisitingHours(String doctorName,String visitingHours);
}
