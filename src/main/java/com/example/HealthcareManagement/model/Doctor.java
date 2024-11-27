package com.example.HealthcareManagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Doctors")
public class Doctor {

    @Id
    private String _id;
    private String doctorName;
    private String specialization;
    private String visitingHours;
    private String contact;

}
