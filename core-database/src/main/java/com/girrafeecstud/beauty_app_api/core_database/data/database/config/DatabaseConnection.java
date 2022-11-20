package com.girrafeecstud.beauty_app_api.core_database.data.database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection = null;

    public Connection getConnection() {

        try {
            Class.forName(DatabaseConfig.databaseDriver);

            connection = DriverManager.getConnection(
                    DatabaseConfig.databaseUrl,
                    DatabaseConfig.databaseUsername,
                    DatabaseConfig.databasePassword
            );

            System.out.println("Connection Ok");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }

        return connection;
    }

}
