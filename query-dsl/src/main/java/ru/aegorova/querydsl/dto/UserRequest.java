package ru.aegorova.querydsl.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String courseName;
}