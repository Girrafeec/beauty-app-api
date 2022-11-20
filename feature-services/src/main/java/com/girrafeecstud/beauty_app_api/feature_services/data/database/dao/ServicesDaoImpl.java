package com.girrafeecstud.beauty_app_api.feature_services.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.model.ServiceDatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServicesDaoImpl extends DatabaseConnection implements ServicesDao {

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
    public List<ServiceDatabaseModel> getServicesList() throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        List<ServiceDatabaseModel> services = new ArrayList<>();

        String getServicesQuery = "select * from services;";

        try {
            statement = connection.prepareStatement(getServicesQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                services.add(
                        new ServiceDatabaseModel(
                                UUID.fromString(resultSet.getString("service_id")),
                                UUID.fromString(resultSet.getString("master_id")),
                                resultSet.getString("service_name"),
                                resultSet.getString("service_description"),
                                resultSet.getDouble("service_price"),
                                resultSet.getInt("service_execution_time")
                        )
                );
            }

            return services;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public ServiceDatabaseModel getServiceData(String serviceId) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        ServiceDatabaseModel service = null;

        String getServiceQuery = "select * from services where service_id=?;";

        try {
            statement = connection.prepareStatement(getServiceQuery);

            statement.setString(1, serviceId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                service = new ServiceDatabaseModel(
                        UUID.fromString(resultSet.getString("service_id")),
                        UUID.fromString(resultSet.getString("master_id")),
                        resultSet.getString("service_name"),
                        resultSet.getString("service_description"),
                        resultSet.getDouble("service_price"),
                        resultSet.getInt("service_execution_time")
                );
            }

            return service;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public List<ServiceDatabaseModel> getMasterServicesList(String masterId) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        List<ServiceDatabaseModel> services = new ArrayList<>();

        String getServicesQuery = "select * from services where master_id=?;";

        try {
            statement = connection.prepareStatement(getServicesQuery);

            statement.setString(1, masterId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                services.add(
                        new ServiceDatabaseModel(
                                UUID.fromString(resultSet.getString("service_id")),
                                UUID.fromString(resultSet.getString("master_id")),
                                resultSet.getString("service_name"),
                                resultSet.getString("service_description"),
                                resultSet.getDouble("service_price"),
                                resultSet.getInt("service_execution_time")
                        )
                );
            }

            return services;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void addService(ServiceDatabaseModel service) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        String insertServiceQuery = "insert into services" +
                " (service_id, master_id, service_name, service_description, service_price, service_execution_time)" +
                " values (uuid(), ?, ?, ?, ?, ?);";

        try {
            statement = connection.prepareStatement(insertServiceQuery);

            statement.setString(1, service.getMasterId().toString());
            statement.setString(2, service.getServiceName());
            statement.setString(3, service.getServiceDescription());
            statement.setDouble(4, service.getServicePrice());
            statement.setInt(5, service.getServiceExecutionTime());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void updateService(ServiceDatabaseModel service, String serviceId) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        String updateServiceQuery = "update services" +
                " set service_name=?, service_description=?, service_price=?, service_execution_time=?" +
                " where service_id=?;";

        try {
            statement = connection.prepareStatement(updateServiceQuery);

            statement.setString(1, service.getServiceName());
            statement.setString(2, service.getServiceDescription());
            statement.setDouble(3, service.getServicePrice());
            statement.setInt(4, service.getServiceExecutionTime());
            statement.setString(5, serviceId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void deleteService(String serviceId) throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        String deleteServiceQuery = "delete from services where service_id=?;";

        try {
            statement = connection.prepareStatement(deleteServiceQuery);

            statement.setString(1, serviceId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }
}
