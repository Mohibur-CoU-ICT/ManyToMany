package com.mohibur.ManyToMany.Service;

import com.mohibur.ManyToMany.Entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> createStudents(List<Student> studentList);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    void deleteStudent(long id);
    void deleteAllStudents();
}
