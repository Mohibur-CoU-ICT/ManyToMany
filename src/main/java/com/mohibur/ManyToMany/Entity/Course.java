package com.mohibur.ManyToMany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String courseTitle;

    @JsonIgnoreProperties("likedCourses")
    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> whoLikes = new HashSet<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public Set<Student> getWhoLikes() {
        return whoLikes;
    }
    public void setWhoLikes(Set<Student> whoLikes) {
        this.whoLikes = whoLikes;
    }

    public Course() {
    }

    public Course(Long id, String courseCode, String courseTitle) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }
}
