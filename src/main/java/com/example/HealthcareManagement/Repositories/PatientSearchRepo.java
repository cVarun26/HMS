package com.example.HealthcareManagement.Repositories;

import com.example.HealthcareManagement.Models.Patient;

import java.util.List;

public interface PatientSearchRepo {
    List<Patient>findByText(String text);
}
