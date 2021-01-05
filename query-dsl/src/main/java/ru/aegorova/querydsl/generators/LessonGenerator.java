package ru.aegorova.querydsl.generators;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ru.aegorova.querydsl.models.Course;
import ru.aegorova.querydsl.models.Lesson;

import java.time.ZoneId;

@Component
public class LessonGenerator {

    private final Faker faker;

    public LessonGenerator(Faker faker) {
        this.faker = faker;
    }

    public Lesson generateLesson(ObjectId courseId) {
        return Lesson.builder()
                .course(courseId)
                .startTime(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalTime())
                .finishTime(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalTime())
                .build();
    }
}
