package com.girrafeecstud.beauty_app_api.feature_customers.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.model.CustomerDatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomersDaoImpl extends DatabaseConnection implements CustomersDao {

    private Connection connection = null;

    // TODO перенести дублирующие методы в DatabaseConnection?
    private void startConnection() {
        connection = getConnection();
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public CustomerDatabaseModel getCustomerData(String customerId) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        CustomerDatabaseModel customer = null;

        String getCustomerQuery = "select customer_id, customer_first_name, customer_last_name, customer_phone_number from customers where customer_id=?;";

        try {
            statement = connection.prepareStatement(getCustomerQuery);

            statement.setString(1, customerId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customer = new CustomerDatabaseModel(
                        UUID.fromString(resultSet.getString("customer_id")),
                        resultSet.getString("customer_first_name"),
                        resultSet.getString("customer_last_name"),
                        resultSet.getString("customer_phone_number")
                );
            }

            return customer;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }
}
