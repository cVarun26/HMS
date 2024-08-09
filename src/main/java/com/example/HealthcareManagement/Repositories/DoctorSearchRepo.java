package com.example.HealthcareManagement.Repositories;

import com.example.HealthcareManagement.Models.Doctor;
import com.example.HealthcareManagement.Models.Patient;

import java.util.List;

public interface DoctorSearchRepo {
    List<Doctor> findByText(String text);
}
