package com.example.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository repository;

    public SchoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/schools")
    public List<SchoolRespDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toSchoolRespDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/schools/{id}")
    public School findOne(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }


    @PostMapping("/schools")
    public SchoolRespDto create(@RequestBody SchoolDto schoolDto) {
        var school = new School(schoolDto.name());
        var savedSchool =  repository.save(school);

        return toSchoolRespDto(savedSchool);
    }

    private SchoolRespDto toSchoolRespDto(School school) {
        return new SchoolRespDto(
                school.getId(),
                school.getName()
        );
    }


}
