package com.mohibur.ManyToMany.Service;

import com.mohibur.ManyToMany.Entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> createCourses(List<Course> courseList);
    List<Course> getAllCourses();
    Course getCourseById(long id);
    void deleteCourse(long id);
    void deleteAllCourses();
}
