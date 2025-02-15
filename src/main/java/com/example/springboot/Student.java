package com.example.springboot;


import jakarta.persistence.*;

@Entity
@Table(name="tbl_students")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "firstname",
            length = 50
    )
    private String firstName;

    @Column(
            name = "lastname",
            length = 50
    )
    private String lastName;

    @Column(
            unique = true
    )
    private String email;

    private Short age;

    public Student() {
    }

    public Student(String firstName, String lastName, Short age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
