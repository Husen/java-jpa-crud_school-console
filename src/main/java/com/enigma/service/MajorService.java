package com.enigma.service;

import com.enigma.model.Major;
import com.enigma.repo.MajorRepo;

import java.util.List;

public class MajorService implements IService<Major>{
    private MajorRepo majorRepo;

    public MajorService(MajorRepo majorRepo) {
        this.majorRepo = majorRepo;
    }

    @Override
    public void insert(Major major) {
        try {
            majorRepo.create(major);
            getAll(1,10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        Major major = getById(id);

        System.out.println("success delete");

        majorRepo.delete(major);

        getAll(1,10);
    }

    @Override
    public void update(Major major) {
        try {
            majorRepo.update(major);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Major getById(Integer id) {
        Major major = new Major();
        try {
            major = majorRepo.findOne(id);
            System.out.println(major);
        } catch (Exception e) {
            System.err.println("id not found");
        }
        return major;
    }

    @Override
    public List<Major> getAll(Integer page, Integer size) {
        List<Major> majors = majorRepo.findAll(page, size);
        majors.forEach(System.out::println);
        return majors;
    }

    @Override
    public List<Major> getByName(String name) {
        return null;
    }
}
