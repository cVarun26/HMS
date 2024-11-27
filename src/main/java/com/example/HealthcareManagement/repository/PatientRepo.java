package com.example.HealthcareManagement.repository;

import com.example.HealthcareManagement.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository<Patient,String> {
}
