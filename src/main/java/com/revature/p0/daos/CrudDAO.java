package com.revature.p0.daos;

import java.util.List;

public interface CrudDAO<T> {

    void save(T obj);

    void update(String id);

    void delete(String id);

    T findByID(String id);

    List<T> findAll();
}
