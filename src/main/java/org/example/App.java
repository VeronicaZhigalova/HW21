package org.example;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.example.service.ProductService;


public class App {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();

        CustomerService customerService = new CustomerService(customerRepository);
        OrderService orderService = new OrderService(orderRepository, productRepository, customerService);
        ProductService productService = new ProductService(productRepository);

        // Create customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customerService.createCustomer(customer);

        //Get customer by ID
        Customer retrievedCustomer = customerService.getById(1).orElse(null);
        if (retrievedCustomer != null) {
            System.out.println("Retrieved customer: " + retrievedCustomer);

            // Update customer
            retrievedCustomer.setName("John Smith");
            customerService.updateCustomer(retrievedCustomer);

            // Delete customer
            customerService.deleteCustomer(retrievedCustomer.getId());
        }

        // Create order
        Order order = new Order();
        order.setId(1);
        order.setCustomerId(1);
        order.setProductId(1);
        orderService.createOrder(order);

        // Get order by ID
        Order retrievedOrder = orderService.getOrderById(1).orElse(null);
        if (retrievedOrder != null) {
            System.out.println("Retrieved order: " + retrievedOrder);

            //Update order
            retrievedOrder.setId(3);
            orderService.updateOrder(retrievedOrder);

            //Delete order
            orderService.deleteOrder(retrievedOrder.getId());
        }

        // Get order by customers ID
        Order retrievedOrders = (Order) orderService.getOrdersByCustomer(1);
        if (retrievedOrders != null) {
            System.out.println("Retrieved order: " + retrievedOrders);

            //Update order
            retrievedOrders.setId(3);
            orderService.updateOrder(retrievedOrders);

            //Delete order
            orderService.deleteOrder(retrievedOrders.getId());
        }

        orderService.getTotalPriceForCustomer(5);

        //Create product
        Product product = new Product();
        product.setId(1);
        product.setName("Product 1");
        product.setPrice(10.0);
        productService.createProduct(product);

        //Get product by ID
        Product retrievedProduct = productService.getById(1).orElse(null);
        if (retrievedProduct != null) {
            System.out.println("Retrieved product: " + retrievedProduct);

            // Update product
            retrievedProduct.setPrice(15.0);
            productService.updateProduct(retrievedProduct);

            //Delete product
            productService.deleteProduct(retrievedProduct.getId());
        }
    }
}