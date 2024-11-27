package com.example.HealthcareManagement.repository;

import com.example.HealthcareManagement.model.Doctor;

import java.util.List;

public interface DoctorSearchRepo {
    List<Doctor> findByText(String text);
}
