package ru.aegorova.querydsl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Document(collection = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class User implements Serializable {

    @Id
    private String _id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;
    
    private Role role;

    private UserState state;
    
    private ObjectId creator;
    
    private List<ObjectId> comments;
    
    private List<ObjectId> courses;
    
    private List<ObjectId> teacherCourses;
}