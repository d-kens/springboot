package com.example.springboot.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/schools")
    public List<SchoolRespDto> findAll() {
        return schoolService.findAll();
    }

    @GetMapping("/schools/{id}")
    public SchoolRespDto findOne(@PathVariable("id") Integer id) {
        return schoolService.findOne(id);
    }


    @PostMapping("/schools")
    public SchoolRespDto create(@RequestBody SchoolDto schoolDto) {
        return schoolService.create(schoolDto);
    }
}
