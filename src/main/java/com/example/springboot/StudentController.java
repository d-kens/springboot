package com.example.springboot;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findOne(@PathVariable("id") Integer id) {
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{name}")
    public List<Student> findByName(@PathVariable("name") String studentName) {
        return repository.findAllByFirstnameContaining(studentName);
    }

    @PostMapping("/students")
    public StudentRespDto create(@RequestBody StudentDto studentDto) {
        var student = toStudent(studentDto);
        var savedStudent =  repository.save(student);

        return toStudentRespDto(savedStudent);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    private Student toStudent(StudentDto studentDto) {
        var school = new School();
        school.setId(studentDto.schoolId());

        var student = new Student();

        student.setFirstname(studentDto.firstname());
        student.setLastname(studentDto.lastname());
        student.setEmail(studentDto.email());
        student.setAge(studentDto.age());
        student.setSchool(school);

        return student;
    }

    private StudentRespDto toStudentRespDto(Student student) {
        return new StudentRespDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

}
