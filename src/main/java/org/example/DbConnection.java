package org.example;


import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Data
public class DbConnection {

    private static DbConnection INSTANCE;
    private Connection connection;

    private DbConnection() {
        this.connection = connect();
    }

    public static DbConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DbConnection();
        }
        return INSTANCE;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/docker",
                    "docker",
                    "docker");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.connectToDatabase();

    }
}
