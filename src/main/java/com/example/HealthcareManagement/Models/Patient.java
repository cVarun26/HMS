package com.example.HealthcareManagement.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Patients")
public class Patient {

    @Id
    private String _id;
    private String PatientName;
    private String PatientAge;
    private String PatientContact;
    private String Illness;
    private String Status;

}
