package com.enigma.repo;

import com.enigma.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepo extends Repo implements IRepo<Student>{
    public StudentRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Student student) {
        inTransaction(em -> {
            em.persist(student);
        });
    }

    @Override
    public List<Student> findAll(Integer page, Integer size) {

        // Versi NamedQuery
        TypedQuery<Student> result = entityManager.createNamedQuery("find all student", Student.class);
        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);
        List<Student> students = result.getResultList();

        // Versi PSQL
//        TypedQuery<Student> result = entityManager.createQuery("select s from Student s", Student.class);
//        result.setFirstResult((page - 1) * size);
//        result.setMaxResults(size);
//        List<Student> students = result.getResultList();

        return students;
    }

    @Override
    public void update(Student student) {
        inTransaction(em -> {
            em.merge(student);
        });
    }

    @Override
    public Student findOne(Integer id) {

        // Versi NamedQuery
        TypedQuery<Student> result = entityManager.createNamedQuery("find by id student",Student.class);
        result.setParameter("id", id);
        Student students = result.getSingleResult();

        // Versi PSQL
//        Student students = entityManager.find(Student.class,id);


        return students;
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> result = entityManager.createQuery("select s from Student s where s.firstName like ?1 ",Student.class);
        result.setParameter(1, "%"+name+"%");
        List<Student> students = result.getResultList();

        return students;
    }

    @Override
    public void delete(Student student) {
        inTransaction(em -> {
            em.remove(student);
        });
    }
}
