package ru.aegorova.querydsl.generators;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.aegorova.querydsl.models.Course;
import ru.aegorova.querydsl.models.User;

import java.time.ZoneId;

@Component
public class CourseGenerator {

    private final Faker faker;

    public CourseGenerator(Faker faker) {
        this.faker = faker;
    }

    public Course generateCourse(ObjectId teacherId, ObjectId creatorId) {
        return Course.builder()
                .description(faker.rickAndMorty().quote())
                .startDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .finishDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .name(faker.programmingLanguage().name())
                .teacher(teacherId)
                .partnerCreator(creatorId)
                .build();
    }
}
