package com.example.springboot;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Short age,
        Integer schoolId
) {
}
