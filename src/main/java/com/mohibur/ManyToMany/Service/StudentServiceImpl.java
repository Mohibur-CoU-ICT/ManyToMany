package com.mohibur.ManyToMany.Service;

import com.mohibur.ManyToMany.Entity.Student;
import com.mohibur.ManyToMany.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> createStudents(List<Student> studentList) {
        return (List<Student>) studentRepository.saveAll(studentList);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional <Student> studentOptional = studentRepository.findById(id);
        Student student;
        if(studentOptional.isPresent()) {
            student = studentOptional.get();
        } else {
            throw new RuntimeException("No course found for id = " + id);
        }
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
