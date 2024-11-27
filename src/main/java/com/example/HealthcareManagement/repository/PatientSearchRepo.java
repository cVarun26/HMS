package com.example.HealthcareManagement.repository;

import com.example.HealthcareManagement.model.Patient;

import java.util.List;

public interface PatientSearchRepo {
    List<Patient>findByText(String text);
}
