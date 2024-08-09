package com.example.HealthcareManagement.Repositories;

import com.example.HealthcareManagement.Models.Patient;
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
public class PatientSearchRepoImp implements PatientSearchRepo {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Patient> findByText(String text) {

        final List<Patient> patients=new ArrayList<>();

        MongoDatabase database = client.getDatabase("Data");
        MongoCollection<Document> collection = database.getCollection("Patients");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                new Document("index", "default")
                                .append("text",
                                         new Document("query", text)
                                                .append("path", Arrays.asList("_id","PatientName")))),
                new Document("$sort",
                        new Document("PatientAge", -1L))));

        result.forEach(doc->patients.add(converter.read(Patient.class,doc)));

        return patients;
    }
}
