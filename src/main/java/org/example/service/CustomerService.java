package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    /**
     * Получить клиента по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента.
     * @return {@link Optional}, содержащий клиента, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Customer> getById(int id) {
        Optional<Customer> customer = Optional.ofNullable(repository.findById(id));
        return customer;
    }


    /**
     * Создать нового клиента и добавить его в репозиторий.
     *
     * @param customer Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором уже существует в репозитории.
     */
    public Customer createCustomer(Customer customer) {
        if (getById(customer.getId()).isPresent()) {
            throw new IllegalArgumentException("Customer with the same id already exists.");
        }
        return repository.create(customer);
    }

    /**
     * Обновить данные клиента.
     *
     * @param customer Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором не существует или обновленный объект не проходит валидацию.
     */
    public Customer updateCustomer(Customer customer) {
        return repository.update(customer);
    }

    /**
     * Удалить клиента по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента, которого нужно удалить.
     * @throws IllegalArgumentException Если клиент с указанным идентификатором не существует в репозитории.
     */
    public void deleteCustomer(int id) {
        Optional<Customer> customer = getById(id);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
        repository.delete(customer.get().getId());
    }
}