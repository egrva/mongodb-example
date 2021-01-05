package ru.aegorova.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.aegorova.querydsl.models.Comment;

public interface CommentsRepository extends MongoRepository<Comment, ObjectId> {
}