package ru.aegorova.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Document(collection = "lesson")
public class Lesson {

    @Id
    private String _id;

    private ObjectId course;

    private LocalTime startTime;
    
    private LocalTime finishTime;
}