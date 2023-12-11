package org.example.repository;

import org.example.entity.Order;

import java.sql.*;

public abstract class OrderRepository implements CrudRepository<Order> {

    private final String url = "jdbc:postgresql://localhost:5432/docker";
    private final String user = "docker";
    private final String password = "docker";

    @Override
    public Order findById(int id) {
        String FIND_BY_ID_QUERY = "SELECT * FROM order WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("id"));
                    order.setCustomerId(resultSet.getInt("customerId"));
                    order.setProductId(resultSet.getInt("productId"));
                    return order;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Order create(Order entity) {
        String query = "INSERT INTO order (customerId, productId) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, entity.getCustomerId());
            statement.setInt(2, entity.getProductId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM order WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 1) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order update(Order entity) {
        String query = "UPDATE order SET customerId = ?, productId = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, entity.getCustomerId());
            statement.setInt(2, entity.getProductId());
            statement.setInt(3, entity.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating order failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }
}