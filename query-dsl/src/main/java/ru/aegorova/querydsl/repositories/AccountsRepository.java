package ru.aegorova.querydsl.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.aegorova.querydsl.models.User;

public interface AccountsRepository extends MongoRepository<User, ObjectId>, QuerydslPredicateExecutor<User> {

}