package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String instructor;
    private String courseCode;

    public Course() {}

    public Course(String title, String instructor, String courseCode) {
        this.title = title;
        this.instructor = instructor;
        this.courseCode = courseCode;
    }

    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public String getCourseCode() {return courseCode; }

    public void setTitle(String title) { this.title = title; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setCourseCode(String courseCode) {this.courseCode = courseCode ; }

    public Long getId() {return id;}
}
