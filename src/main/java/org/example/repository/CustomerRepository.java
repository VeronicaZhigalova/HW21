package org.example.repository;

import org.example.entity.Customer;

public class CustomerRepository implements CrudRepository<Customer>{
    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public Customer create(Customer entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }
}
