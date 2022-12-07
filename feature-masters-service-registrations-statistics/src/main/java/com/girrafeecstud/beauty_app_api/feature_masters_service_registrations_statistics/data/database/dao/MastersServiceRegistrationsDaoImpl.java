package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.model.MastersServiceRegistrationsDatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MastersServiceRegistrationsDaoImpl
        extends DatabaseConnection
        implements MastersServiceRegistrationsDao {

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
    public List<MastersServiceRegistrationsDatabaseModel> getMastersServiceRegistrations() throws SQLException {
        startConnection();

        PreparedStatement statement = null;

        List<MastersServiceRegistrationsDatabaseModel> mastersServiceRegistrations = new ArrayList<>();

        String getServicesQuery = "select distinct masters.master_id," +
                " (select count(*) from service_registrations " +
                " where service_id in (select service_id from services where master_id=masters.master_id))" +
                " as service_registrations_count from masters;";

        try {
            statement = connection.prepareStatement(getServicesQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                mastersServiceRegistrations.add(
                        new MastersServiceRegistrationsDatabaseModel(
                                UUID.fromString(resultSet.getString("master_id")),
                                resultSet.getInt("service_registrations_count")
                        )
                );
            }

            return mastersServiceRegistrations;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }
}
