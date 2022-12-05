package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.model.ServiceRegistrationDatabaseModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServiceRegistrationsDaoImpl extends DatabaseConnection implements ServiceRegistrationsDao {

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
    public void addServiceRegistration(ServiceRegistrationDatabaseModel serviceRegistration) throws SQLException {
        startConnection();
        PreparedStatement statement = null;

        String addServiceRegistrationQuery = "insert into service_registrations" +
                " (service_registration_id, customer_id, service_id, service_timestamp, service_note)" +
                " values (uuid(), ?, ?, ?, ?);";

        try {
            statement = connection.prepareStatement(addServiceRegistrationQuery);

            statement.setString(1, serviceRegistration.getCustomerId().toString());
            statement.setString(2, serviceRegistration.getServiceId().toString());
            statement.setTimestamp(3, Timestamp.valueOf(serviceRegistration.getServiceRegistrationTimestamp()));
            statement.setString(4, serviceRegistration.getServiceRegistrationNote());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public List<ServiceRegistrationDatabaseModel> getCustomerServiceRegistrations(String customerId) throws SQLException {
        startConnection();
        PreparedStatement statement = null;

        List<ServiceRegistrationDatabaseModel> serviceRegistrations = new ArrayList<>();

        String getCustomerServiceRegistrationsQuery = "select * from service_registrations" +
                " where customer_id=?;";

        try {
            statement = connection.prepareStatement(getCustomerServiceRegistrationsQuery);

            statement.setString(1, customerId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                serviceRegistrations.add(
                        new ServiceRegistrationDatabaseModel(
                                UUID.fromString(resultSet.getString("service_registration_id")),
                                UUID.fromString(resultSet.getString("customer_id")),
                                UUID.fromString(resultSet.getString("service_id")),
                                resultSet.getTimestamp("service_timestamp").toLocalDateTime(),
                                resultSet.getString("service_note")
                        )
                );
            }

            return serviceRegistrations;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public List<ServiceRegistrationDatabaseModel> getMasterServiceRegistrations(String masterId) throws SQLException {
        startConnection();
        PreparedStatement statement = null;

        List<ServiceRegistrationDatabaseModel> serviceRegistrations = new ArrayList<>();

        String getMasterServiceRegistrationsQuery = "select * from service_registrations" +
                " where service_id in (select service_id from services where master_id=?);";

        try {
            statement = connection.prepareStatement(getMasterServiceRegistrationsQuery);

            statement.setString(1, masterId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                serviceRegistrations.add(
                        new ServiceRegistrationDatabaseModel(
                                UUID.fromString(resultSet.getString("service_registration_id")),
                                UUID.fromString(resultSet.getString("customer_id")),
                                UUID.fromString(resultSet.getString("service_id")),
                                resultSet.getTimestamp("service_timestamp").toLocalDateTime(),
                                resultSet.getString("service_note")
                        )
                );
            }

            return serviceRegistrations;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public ServiceRegistrationDatabaseModel getServiceRegistrationData(String serviceRegistrationId) throws SQLException {
        startConnection();
        PreparedStatement statement = null;

        ServiceRegistrationDatabaseModel serviceRegistration = null;

        String getServiceRegistrationDataQuery = "select * from service_registrations" +
                " where service_registration_id=?;";

        try {
            statement = connection.prepareStatement(getServiceRegistrationDataQuery);

            statement.setString(1, serviceRegistrationId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getTimestamp("service_timestamp"));
                serviceRegistration = new ServiceRegistrationDatabaseModel(
                        UUID.fromString(resultSet.getString("service_registration_id")),
                        UUID.fromString(resultSet.getString("customer_id")),
                        UUID.fromString(resultSet.getString("service_id")),
                        resultSet.getTimestamp("service_timestamp").toLocalDateTime(),
                        resultSet.getString("service_note")
                );
            }

            System.out.println(serviceRegistration.getServiceRegistrationTimestamp());
            System.out.println(serviceRegistration.getServiceRegistrationNote());
            return serviceRegistration;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }
}
