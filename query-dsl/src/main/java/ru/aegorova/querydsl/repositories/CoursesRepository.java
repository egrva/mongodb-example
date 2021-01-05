package ru.aegorova.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.aegorova.querydsl.models.Course;

public interface CoursesRepository extends MongoRepository<Course, ObjectId> {
}