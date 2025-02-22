package com.example.springboot.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("Dickens", "Dickens", "dickens@gmail.com", 30, 1);

        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentRespDto() {
        Student student = new Student("Dickens", "Dickens", "owangsino@gmail.com", 30);
        StudentRespDto studentRespDto = studentMapper.toStudentRespDto(student);

        assertEquals(student.getFirstname(), studentRespDto.firstname());
        assertEquals(student.getLastname(), studentRespDto.lastname());
        assertEquals(student.getEmail(), studentRespDto.email());

    }
}