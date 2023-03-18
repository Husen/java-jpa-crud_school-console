package com.enigma.repo;

import java.util.List;

public interface IRepo<T> {
    void create(T params);
    List<T> findAll(Integer page, Integer size);
    void update(T params);
    T findOne(Integer id);
    List<T> findByName(String name);
    void delete(T params);
}
