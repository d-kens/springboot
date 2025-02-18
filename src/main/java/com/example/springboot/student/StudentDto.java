package com.example.springboot.student;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Short age,
        Integer schoolId
) {
}
