package com.enigma.repo;

import com.enigma.model.Major;
import com.enigma.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MajorRepo extends Repo implements IRepo<Major>{
    public MajorRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Major major) {
        inTransaction(em -> {
            em.persist(major);
        });
    }

    @Override
    public List<Major> findAll(Integer page, Integer size) {

        // versi NamedQuery
        TypedQuery<Major> result = entityManager.createNamedQuery("find all major", Major.class);
        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);
        List<Major> majors = result.getResultList();

        // Versi PSQL
        // ...

        return majors;
    }

    @Override
    public void update(Major major) {
        inTransaction(em -> {
            em.merge(major);
        });
    }

    @Override
    public Major findOne(Integer id) {
        TypedQuery<Major> result = entityManager.createNamedQuery("find by id major",Major.class);
        result.setParameter("id", id);
        Major major = result.getSingleResult();
        return major;
    }

    @Override
    public List<Major> findByName(String name) {
        return null;
    }

    @Override
    public void delete(Major major) {
        inTransaction(em -> {
            em.remove(major);
        });
    }
}
