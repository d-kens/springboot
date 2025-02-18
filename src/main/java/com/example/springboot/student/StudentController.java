package com.example.springboot.student;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentRespDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentRespDto findOne(@PathVariable("id") Integer id) {
      return studentService.findOne(id);
    }

    @GetMapping("/students/search/{name}")
    public List<StudentRespDto> findByName(@PathVariable("name") String studentName) {
        return studentService.findByName(studentName);
    }

    @PostMapping("/students")
    public StudentRespDto create(@RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
    }

}
