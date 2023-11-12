package org.example.repository;

import org.example.entity.Order;

public class OrderRepository implements CrudRepository<Order> {
    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Order update(Order entity) {
        return null;
    }
}
