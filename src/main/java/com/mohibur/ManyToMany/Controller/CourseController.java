package com.mohibur.ManyToMany.Controller;

import com.mohibur.ManyToMany.Entity.Course;
import com.mohibur.ManyToMany.Repository.CourseRepository;
import com.mohibur.ManyToMany.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "/byCourseCode")
    public Course getByCourseCode(@RequestParam("courseCode") String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }

    @PostMapping(value = "/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PostMapping(value = "/create/many")
    public List<Course> createCourses(@RequestBody List<Course> courseList) {
        return courseService.createCourses(courseList);
    }

    @GetMapping(value = "/{id}")
    public Course getCourseById(@PathVariable("id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping(value = "")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping(value = "/update/{id}")
    public Course updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
        Course course1 = courseService.getCourseById(id);

        if(course.getCourseTitle() != null) course1.setCourseTitle(course.getCourseTitle());
        if(course.getCourseCode() != null)  course1.setCourseCode(course.getCourseCode());
        if(course.getWhoLikes() != null)    course1.getWhoLikes().addAll(course.getWhoLikes());

        return courseService.createCourse(course1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
    }

    @DeleteMapping(value = "/delete/all")
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}
