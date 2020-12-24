package com.company.project.services;

import java.util.List;

public interface BaseService <T> {
    List<T>getAll();
    T getById(Long id);
    T create (T model);
    T update(T model);
    void delete(T model);

}
