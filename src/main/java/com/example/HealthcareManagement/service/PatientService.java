package com.example.HealthcareManagement.service;

import com.example.HealthcareManagement.model.Patient;
import com.example.HealthcareManagement.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PatientService {


        @Autowired
        private PatientRepo patientRepo;

        public Patient updatePatient(String id, Patient patientDetails) {
            Optional<Patient> patientOptional = patientRepo.findById(id);
            if (patientOptional.isPresent()) {
                Patient patient = patientOptional.get();
                patient.setPatientName(patientDetails.getPatientName());
                patient.setPatientAge(patientDetails.getPatientAge());
                patient.setPatientContact(patientDetails.getPatientContact());
                patient.setIllness(patientDetails.getIllness());
                patient.setStatus(patientDetails.getStatus());
                return patientRepo.save(patient);
            } else {
                throw new RuntimeException("Patient not found with id " + id);
            }
        }
    }


