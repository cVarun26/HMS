package com.example.HealthcareManagement.repository;

import com.example.HealthcareManagement.model.Doctor;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DoctorSearchRepoImp implements DoctorSearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Doctor> findByText(String text) {

        final List<Doctor> doctors=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("Data");
        MongoCollection<Document> collection = database.getCollection("Doctors");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("doctorName", "specialization"))))));

        result.forEach(doc->doctors.add(converter.read(Doctor.class,doc)));

        return doctors;

    }
}
