package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.entity.Order;
import org.example.entity.Product;

import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;


    /**
     * Получить заказ по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор заказа.
     * @return {@link Optional}, содержащий заказ, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Order> getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    /**
     * Получить список заказов, связанных с конкретным клиентом.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Список заказов, связанных с клиентом.
     */
    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> orders = orderRepository.getOrdersByCustomer(customerId);
        return new ArrayList<>(orders);
    }


    /**
     * Рассчитать общую стоимость всех заказов для конкретного клиента.
     *
     * @param customerId Уникальный идентификатор клиента.
     * @return Общая стоимость всех заказов для клиента.
     */
    public double getTotalPriceForCustomer(int customerId) {
        List<Order> orders = orderRepository.getOrdersByCustomer(customerId);
        double totalPrice = 0.0;
        for (Order order : orders) {
            Optional<Product> product = productRepository.getProductById(order.getProductId());
            totalPrice += product.map(Product::getPrice).orElse(0.0);
        }
        return totalPrice;
    }

    /**
     * Создать новый заказ и добавить его в репозиторий.
     *
     * @param order Заказ, который нужно создать и добавить.
     * @throws IllegalArgumentException Если заказ уже существует в репозитории.
     */
    public Order createOrder(Order order) {
        if (orderRepository.getOrderById(order.getId()).isPresent()) {
            throw new IllegalArgumentException("Order with the same id already exists.");
        }
        return orderRepository.create(order);
    }


    /**
     * Обновить данные заказа.
     *
     * @param order Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором не существует или обновленный объект не проходит валидацию.
     */
    public Order updateOrder(Order order) {
        return orderRepository.update(order);
    }

    /**
     * Удалить заказ по его уникальному идентификатору.
     *
     * @param orderId Уникальный идентификатор заказа, который нужно удалить.
     * @throws IllegalArgumentException Если заказ с указанным идентификатором не существует в репозитории.
     */
    public void deleteOrder(int orderId) {
        Optional<Order> order = getOrderById(orderId);
        if (order.isEmpty()) {
            throw new IllegalArgumentException("Order with id " + orderId + " does not exist.");
        }
        orderRepository.delete(orderId);
    }
}