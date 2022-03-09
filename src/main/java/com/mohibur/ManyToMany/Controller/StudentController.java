package com.mohibur.ManyToMany.Controller;

import com.mohibur.ManyToMany.Entity.Student;
import com.mohibur.ManyToMany.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PostMapping(value = "/create/many")
    public List<Student> createStudents(@RequestBody List<Student> studentList) {
        return studentService.createStudents(studentList);
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping(value = "/update/{id}")
    public Student updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Student student1 = studentService.getStudentById(id);

        if(student.getName() != null)    student1.setName(student.getName());
        if(student.getSession() != null) student1.setSession(student.getSession());
        if(student.getLikedCourses() != null) student1.getLikedCourses().addAll(student.getLikedCourses());

        return studentService.createStudent(student1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping(value = "/delete/all")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }
}
