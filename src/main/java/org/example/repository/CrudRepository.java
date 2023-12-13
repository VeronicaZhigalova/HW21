package org.example.repository;

import org.example.entity.Order;
import org.example.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T findById(int id);

    T create(T entity);

    void delete(int id);

    T update(T entity);

}
