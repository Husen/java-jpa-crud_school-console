package com.enigma.service;

import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repo.StudentRepo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student> {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void insert(Student student, UserCredential userCredential, Integer clubId) {

    }

    @Override
    public void insert(Student student) {
        try {
            studentRepo.create(student);
            List<Student> students = getAll(1, 10);
            students.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        Student student = getById(id); // validasi cek id student

        System.out.println("Success delete :"); // alert success delete

        System.out.println(student); // menampilkan data yg di hapus

        studentRepo.delete(student); // fungsi delete di jalankan

        List<Student> students = getAll(1,10); // menjalankan fungsi getAll
        students.forEach(System.out::println); // menampilkan list student page 1 dan 10 data
    }

    @Override
    public void update(Student student) {
        try {
            studentRepo.update(student); // fungsi update
            List<Student> students = getAll(1,10); // menjalankan fungsi getAll
            students.forEach(System.out::println); // menampilkan list student page 1 dan 10 data
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Student getById(Integer id) {
        Student student = new Student();
        try {
            studentRepo.findOne(id);
        } catch (Exception e) {
            System.err.println("Fail, id not found");
        }
        return student;
    }

    @Override
    public List<Student> getAll(Integer page, Integer size) {
        List<Student> students = new ArrayList<>();
        try {
            students = studentRepo.findAll(page, size);
        } catch (Exception e) {
            System.err.println("List empty");
        }
        return students;
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> student = new ArrayList<>();
        try {
            student = studentRepo.findByName(name);
        } catch (Exception e) {
            System.err.println("Empty");
        }
        return student;
    }
}
