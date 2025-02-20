package com.example.springboot.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "firstname should not be empty")
        String firstname,

        @NotEmpty(message = "lastname shoulkd not be empty")
        String lastname,

        String email,
        Integer age,
        Integer schoolId
) {
}
