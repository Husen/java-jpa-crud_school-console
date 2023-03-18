package com.enigma.controller;

public interface IController<T> {
    void create(T params);

    void findAll(T params);

    void findById(Integer id);

    void findByName(String name);

    void update(T params);

    void delete(Integer id);
}
