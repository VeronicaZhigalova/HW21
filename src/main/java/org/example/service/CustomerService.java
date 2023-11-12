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
        return null;
    }

    /**
     * Создать нового клиента и добавить его в репозиторий.
     *
     * @param customer Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором уже существует в репозитории.
     */
    public Customer createCustomer(Customer customer) {
        return null;
    }

    /**
     * Обновить данные клиента.
     *
     * @param customer Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором не существует или обновленный объект не проходит валидацию.
     */
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    /**
     * Удалить клиента по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента, которого нужно удалить.
     * @throws IllegalArgumentException Если клиент с указанным идентификатором не существует в репозитории.
     */
    public void deleteCustomer(int id) {
    }
}