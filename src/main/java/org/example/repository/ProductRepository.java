package org.example.repository;

import org.example.entity.Product;

public class ProductRepository implements CrudRepository<Product> {
    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}
