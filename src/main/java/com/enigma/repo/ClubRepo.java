package com.enigma.repo;

import com.enigma.model.Club;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClubRepo extends Repo implements IRepo<Club> {
    public ClubRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Club club) {
        inTransaction(em -> {
            em.persist(club);
        });
    }

    @Override
    public List<Club> findAll(Integer page, Integer size) {
        TypedQuery<Club> result = entityManager.createNamedQuery("find all club",Club.class);
        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);
        List<Club> clubs = result.getResultList();

        return clubs;
    }

    @Override
    public void update(Club club) {

    }

    @Override
    public Club findOne(Integer id) {
        return null;
    }

    @Override
    public List<Club> findByName(String name) {
        return null;
    }

    @Override
    public void delete(Club club) {
        inTransaction(em -> {
            em.remove(club);
        });
    }
}
