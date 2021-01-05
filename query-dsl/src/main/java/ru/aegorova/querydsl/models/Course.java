package ru.aegorova.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Document(collection = "course")
public class Course {

    @Id
    private String _id;

    private String name;

    private String description;

    private ObjectId teacher;

    private ObjectId partnerCreator;

    private LocalDate startDate;

    private LocalDate finishDate;

    private List<ObjectId> students;

    private List<ObjectId> lessons;
}
