package com.example.springboot.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentRespDto create(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent =  repository.save(student);
        return studentMapper.toStudentRespDto(savedStudent);
    }


    public List<StudentRespDto> findAll() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentRespDto)
                .collect(Collectors.toList());
    }

    public StudentRespDto findOne(Integer id) {
        return repository.findById(id)
                .map(studentMapper::toStudentRespDto)
                .orElse(null);
    }

    public List<StudentRespDto> findByName(String name) {
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentRespDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
