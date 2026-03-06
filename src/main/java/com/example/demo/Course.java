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

    public Course(String title, String instructor, String courseNUM) {
        this.title = title;
        this.instructor = instructor;
        this.courseCode = courseCode;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public String getCourseNUM() {return courseCode; }

    public void setTitle(String title) { this.title = title; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setCourseNUM(String courseNUM) {this.courseCode = courseNUM ; }
}
