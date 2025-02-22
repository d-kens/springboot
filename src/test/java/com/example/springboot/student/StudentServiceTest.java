package com.example.springboot.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullyCreateStudent() {
        StudentDto studentDto = new StudentDto("Dickens", "Dickens", "omoke@gmail.com", 10, 1);
        Student student =  new Student("Dickens", "Dickens", "omoke@gmail.com", 10);
        Student savedStudent = new Student("Dickens", "Dickens", "omoke@gmail.com", 10);
        savedStudent.setId(1);

        // Mock the calls
        Mockito.when(studentMapper.toStudent(studentDto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentRespDto(savedStudent)).thenReturn(new StudentRespDto("Dickens", "Dickens", "omoke@gmail.com"));

        StudentRespDto studentRespDto = studentService.create(studentDto);

        assertEquals(studentDto.firstname(), studentRespDto.firstname());
        assertEquals(studentDto.lastname(), studentRespDto.lastname());
        assertEquals(studentDto.email(), studentRespDto.email());

        Mockito.verify(studentMapper, Mockito.times(1)).toStudent(studentDto);
        Mockito.verify(repository, Mockito.times(1)).save(student);
        Mockito.verify(studentMapper, Mockito.times(1)).toStudentRespDto(savedStudent);
    }

    @Test
    public void shouldSuccessfullyReturnAListOfStudentRespDtoWhenWeFetchAll() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dickens", "Dickens", "omoke@gmail.com", 1));

        // Mock the calls
        Mockito.when(repository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.toStudentRespDto(ArgumentMatchers.any(Student.class))).thenReturn(new StudentRespDto(
                "Dickens",
                "Dickens",
                "omoke@gmail.com"
        ));

        // When
        List<StudentRespDto> respDtoList = studentService.findAll();

        // Then
        assertEquals(students.size(), respDtoList.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnStudentResponseDtoWhenWeFetchById() {
        // Given
        Student student =  new Student("Dickens", "Dickens", "omoke@gmail.com", 1);
        Integer studentId = 1;

        // Mock the calls
        Mockito.when(repository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentRespDto(ArgumentMatchers.any(Student.class))).thenReturn(new StudentRespDto(
                "Dickens",
                "Dickens",
                "omoke@gmail.com"
        ));

        // When
        StudentRespDto studentRespDto = studentService.findOne(studentId);

        // Then
        assertEquals(student.getFirstname(), studentRespDto.firstname());
        assertEquals(student.getLastname(), studentRespDto.lastname());
        assertEquals(student.getEmail(), studentRespDto.email());

        Mockito.verify(repository, Mockito.times(1)).findById(studentId);
    }

    @Test
    void shouldSuccessfullyReturnAListOfStudentRespDtoWhenWeFetchByName() {
        // Given
        String studentName = "Dickens";
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dickens", "Dickens", "omoke@gmail.com", 1));
        students.add(new Student("Nyoaki", "Dickens", "nyoaki@gmail.com", 1));

        // Mock the calls
        Mockito.when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        Mockito.when(studentMapper.toStudentRespDto(ArgumentMatchers.any(Student.class))).thenReturn(new StudentRespDto(
                "Dickens",
                "Dickens",
                "omoke@gmail.com"
        ));

        // When
        List<StudentRespDto> respDtoList = studentService.findByName(studentName);

        // Then
        assertEquals(students.size(), respDtoList.size());
        Mockito.verify(repository, Mockito.times(1)).findAllByFirstnameContaining(studentName);
    }



}