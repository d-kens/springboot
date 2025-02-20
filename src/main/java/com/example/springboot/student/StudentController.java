package com.example.springboot.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public StudentRespDto create(@Valid @RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
