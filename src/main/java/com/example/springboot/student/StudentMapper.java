package com.example.springboot.student;


import com.example.springboot.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto studentDto) {
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

    public StudentRespDto toStudentRespDto(Student student) {
        return new StudentRespDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
