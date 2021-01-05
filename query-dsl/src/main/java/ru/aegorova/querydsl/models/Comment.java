package ru.aegorova.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Document(collection = "comment")
public class Comment {

    @Id
    private String _id;

    private String text;

    private ObjectId user;
}