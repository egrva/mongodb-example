package ru.aegorova.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.aegorova.querydsl.models.Lesson;

public interface LessonsRepository extends MongoRepository<Lesson, ObjectId> {
}