package com.example.HealthcareManagement.Repositories;

import com.example.HealthcareManagement.Models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository<Patient,String> {
}
