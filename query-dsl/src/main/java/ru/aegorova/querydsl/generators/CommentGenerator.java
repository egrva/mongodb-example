package ru.aegorova.querydsl.generators;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.aegorova.querydsl.models.Comment;
import ru.aegorova.querydsl.models.User;

@Component
public class CommentGenerator {

    private final Faker faker;

    public CommentGenerator(Faker faker) {
        this.faker = faker;
    }

    public Comment generateComment(ObjectId userId) {
        return Comment.builder()
                .user(userId)
                .text(faker.rickAndMorty().quote())
                .build();
    }
}
