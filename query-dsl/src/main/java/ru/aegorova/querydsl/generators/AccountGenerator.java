package ru.aegorova.querydsl.generators;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aegorova.querydsl.models.Role;
import ru.aegorova.querydsl.models.User;
import ru.aegorova.querydsl.models.UserState;

@Component
public class AccountGenerator {

    private final Faker faker;

    public AccountGenerator(Faker faker) {
        this.faker = faker;
    }

    private User generateUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .state(UserState.CONFIRMED)
                .build();
    }

    public User generateStudent(ObjectId creator) {
        User student = generateUser();
        student.setRole(Role.STUDENT);
        student.setCreator(creator);
        return student;
    }

    public User generateAdmin() {
        User admin = generateUser();
        admin.setRole(Role.ADMIN);
        return admin;
    }

    public User generateTeacher(ObjectId creator) {
        User admin = generateUser();
        admin.setRole(Role.TEACHER);
        admin.setCreator(creator);
        return admin;
    }
}
