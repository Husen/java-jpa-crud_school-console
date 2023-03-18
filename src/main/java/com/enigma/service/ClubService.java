package com.enigma.service;

import com.enigma.model.Club;
import com.enigma.repo.ClubRepo;

import java.util.List;

public class ClubService implements IService<Club> {
    private ClubRepo clubRepo;

    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public void insert(Club club) {
        clubRepo.create(club);
        getAll(1, 10);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Club params) {

    }

    @Override
    public Club getById(Integer id) {
        return null;
    }

    @Override
    public List<Club> getAll(Integer page, Integer size) {
        List<Club> clubs = clubRepo.findAll(page, size);
        clubs.forEach(System.out::println);
        return clubs;
    }

    @Override
    public List<Club> getByName(String name) {
        return null;
    }
}
