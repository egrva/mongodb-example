package ru.aegorova.querydsl;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.aegorova.querydsl.generators.AccountGenerator;
import ru.aegorova.querydsl.generators.CommentGenerator;
import ru.aegorova.querydsl.generators.CourseGenerator;
import ru.aegorova.querydsl.generators.LessonGenerator;
import ru.aegorova.querydsl.models.Comment;
import ru.aegorova.querydsl.models.Course;
import ru.aegorova.querydsl.models.Lesson;
import ru.aegorova.querydsl.models.User;
import ru.aegorova.querydsl.repositories.AccountsRepository;
import ru.aegorova.querydsl.repositories.CommentsRepository;
import ru.aegorova.querydsl.repositories.CoursesRepository;
import ru.aegorova.querydsl.repositories.LessonsRepository;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class QueryDslApplication {
    
    @Bean
    Faker faker() {
        return new Faker();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QueryDslApplication.class, args);
        generateData(context);
    }

    private static void generateData(ApplicationContext context) {
        AccountsRepository accountsRepository = context.getBean(AccountsRepository.class);
        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
        LessonsRepository lessonsRepository = context.getBean(LessonsRepository.class);
        CommentsRepository commentsRepository = context.getBean(CommentsRepository.class);

        AccountGenerator accountGenerator = context.getBean(AccountGenerator.class);
        CommentGenerator commentGenerator = context.getBean(CommentGenerator.class);
        LessonGenerator lessonGenerator = context.getBean(LessonGenerator.class);
        CourseGenerator courseGenerator = context.getBean(CourseGenerator.class);


        User admin = accountGenerator.generateAdmin();
        accountsRepository.save(admin);

        User student1 = accountGenerator.generateStudent(new ObjectId(admin.get_id()));
        User student2 = accountGenerator.generateStudent(new ObjectId(admin.get_id()));
        User student3 = accountGenerator.generateStudent(new ObjectId(admin.get_id()));
        User teacher1 = accountGenerator.generateTeacher(new ObjectId(admin.get_id()));
        User teacher2 = accountGenerator.generateTeacher(new ObjectId(admin.get_id()));

        accountsRepository.save(student1);
        accountsRepository.save(student2);
        accountsRepository.save(student3);
        accountsRepository.save(teacher1);
        accountsRepository.save(teacher2);

        Course course1 = courseGenerator.generateCourse(new ObjectId(teacher1.get_id()),new ObjectId(admin.get_id()));
        Course course2 = courseGenerator.generateCourse(new ObjectId(teacher2.get_id()), new ObjectId(admin.get_id()));

        coursesRepository.save(course1);
        coursesRepository.save(course2);

        student1.setCourses(Collections.singletonList(new ObjectId(course1.get_id())));
        student2.setCourses(Arrays.asList(new ObjectId(course1.get_id()), new ObjectId(course2.get_id())));
        student3.setCourses(Collections.singletonList(new ObjectId(course2.get_id())));

        accountsRepository.save(student1);
        accountsRepository.save(student2);
        accountsRepository.save(student3);

        Lesson lesson1 = lessonGenerator.generateLesson(new ObjectId(course1.get_id()));
        Lesson lesson2 = lessonGenerator.generateLesson(new ObjectId(course1.get_id()));
        Lesson lesson3 = lessonGenerator.generateLesson(new ObjectId(course2.get_id()));
        Lesson lesson4 = lessonGenerator.generateLesson(new ObjectId(course2.get_id()));

        lessonsRepository.save(lesson1);
        lessonsRepository.save(lesson2);
        lessonsRepository.save(lesson3);
        lessonsRepository.save(lesson4);

        Comment comment1 = commentGenerator.generateComment(new ObjectId(student1.get_id()));
        Comment comment2 = commentGenerator.generateComment(new ObjectId(student2.get_id()));
        Comment comment3 = commentGenerator.generateComment(new ObjectId(student3.get_id()));
        Comment comment4 = commentGenerator.generateComment(new ObjectId(teacher1.get_id()));
        Comment comment5 = commentGenerator.generateComment(new ObjectId(teacher2.get_id()));

        commentsRepository.save(comment1);
        commentsRepository.save(comment2);
        commentsRepository.save(comment3);
        commentsRepository.save(comment4);
        commentsRepository.save(comment5);
    }

}
