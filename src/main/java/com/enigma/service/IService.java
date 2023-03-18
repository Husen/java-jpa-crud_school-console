package com.enigma.service;

import java.util.List;

public interface IService<T> {
    public void insert(T params);
    public void delete(Integer id);
    public void update(T params);
    public T getById(Integer id);
    public List<T> getAll(Integer page, Integer size);
    public List<T> getByName(String name);
}
