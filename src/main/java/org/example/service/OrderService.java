package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Order;
import org.example.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    /**
     * Получить заказ по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор заказа.
     * @return {@link Optional}, содержащий заказ, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Order> getOrderById(int id) {
       return null;
    }

    /**
     * Получить список заказов, связанных с конкретным клиентом.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Список заказов, связанных с клиентом.
     */
    public List<Order> getOrdersByCustomer(int customerId) {
       return null;
    }

    /**
     * Рассчитать общую стоимость всех заказов для конкретного клиента.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Общая стоимость всех заказов для клиента.
     */
    public double getTotalPriceForCustomer(int customerId) {
        return 0;
    }

    /**
     * Создать новый заказ и добавить его в репозиторий.
     *
     * @param order Заказ, который нужно создать и добавить.
     * @throws IllegalArgumentException Если заказ уже существует в репозитории.
     */
    public Order createOrder(Order order) {
        return null;
    }

    /**
     * Обновить данные заказа.
     *
     * @param order Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором не существует или обновленный объект не проходит валидацию.
     */
    public Order updateOrder(Order order) {
        return null;
    }

    /**
     * Удалить заказ по его уникальному идентификатору.
     *
     * @param orderId Уникальный идентификатор заказа, который нужно удалить.
     * @throws IllegalArgumentException Если заказ с указанным идентификатором не существует в репозитории.
     */
    public void deleteOrder(int orderId) {

    }

}