package org.example.repository;

public interface CrudRepository <T> {

    T findById(int id);

    T create(T entity);

    void delete(int id);

    T update (T entity);
}
