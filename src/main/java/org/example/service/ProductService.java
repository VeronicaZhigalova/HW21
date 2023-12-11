package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Product;
import org.example.repository.ProductRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Получить продукт по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор продукта.
     * @return {@link Optional}, содержащий продукт, если найден, или пустой {@link Optional}, если не найден.
     */
    public Optional<Product> getById(int id) {
        return productRepository.getProductById(id);
    }

    /**
     * Создать новый продукт и добавить его в репозиторий.
     *
     * @param product Продукт, который нужно создать и добавить.
     * @throws IllegalArgumentException Если продукт с таким идентификатором уже существует в репозитории.
     */
    public Product createProduct(Product product) {
        if (productRepository.getOrderById(product.getId()).isPresent()) {
            throw new IllegalArgumentException("Product with the same id already exists.");
        }
        return productRepository.create(product);
    }


    /**
     * Обновить данные продукта.
     *
     * @param product Клиент, которого нужно создать и добавить.
     * @throws IllegalArgumentException Если клиент с таким идентификатором не существует или обновленный объект не проходит валидацию.
     */
    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    /**
     * Удалить продукт по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор продукта, который нужно удалить.
     * @throws IllegalArgumentException Если продукт с указанным идентификатором не существует в репозитории.
     */
    public void deleteProduct(int id) {
        Optional<Product> product = getById(id);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product with id " + id + " does not exist.");
        }
        productRepository.delete(id);
    }
}