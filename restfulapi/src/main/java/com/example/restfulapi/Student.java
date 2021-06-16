package com.example.restfulapi;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public Student(String name,String email,LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setName() {
    }

    public void isPresent() {
    }
}
