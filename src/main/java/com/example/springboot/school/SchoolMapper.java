package com.example.springboot.school;


import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public SchoolRespDto toSchoolRespDto(School school) {
        return new SchoolRespDto(
                school.getId(),
                school.getName()
        );
    }
}
