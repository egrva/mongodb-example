package ru.aegorova.querydsl.controllers;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aegorova.querydsl.dto.UserDto;
import ru.aegorova.querydsl.models.Course;
import ru.aegorova.querydsl.models.User;
import ru.aegorova.querydsl.repositories.AccountsRepository;
import ru.aegorova.querydsl.repositories.CoursesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class SearchController {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping("/accounts/search")
    public ResponseEntity<List<UserDto>> searchByPredicate(
            @QuerydslPredicate(root = User.class) Predicate predicate) {
        return ResponseEntity.ok(
                StreamSupport.stream(accountsRepository.findAll(predicate).spliterator(), true)
                        .map(user -> {
                                    System.out.println("Userrr: " + user);
                                    List<String> courseNames;
                                    if (user.getCourses() != null){
                                        courseNames = user.getCourses().stream().map(course -> {
                                                    Course course1 = coursesRepository.findById(course)
                                                            .orElse(null);
                                                    System.out.println("course: " + course1);
                                                    return course1.getName();
                                                }
                                        ).collect(Collectors.toList());
                                    } else {
                                        courseNames = null;
                                    }
                                    return UserDto.builder()
                                            .firstName(user.getFirstName())
                                            .lastName(user.getLastName())
                                            .courseNames(courseNames)
                                            .build();
                                }
                        ).collect(Collectors.toList()));
    }
}