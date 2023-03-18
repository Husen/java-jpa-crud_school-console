package com.enigma.controller;

import com.enigma.model.Student;
import com.enigma.service.StudentService;

public class StudentController implements IController<Student> {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void create(Student student) {
        studentService.insert(student);
    }

    @Override
    public void findAll(Student params) {

    }

    @Override
    public void findById(Integer id) {

    }

    @Override
    public void findByName(String name) {

    }

    @Override
    public void update(Student params) {

    }

    @Override
    public void delete(Integer id) {

    }
}
