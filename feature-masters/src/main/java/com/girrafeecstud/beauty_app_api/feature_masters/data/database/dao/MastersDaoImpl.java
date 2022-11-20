package com.girrafeecstud.beauty_app_api.feature_masters.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_masters.data.database.model.MasterDatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MastersDaoImpl extends DatabaseConnection implements MastersDao {

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
    public List<MasterDatabaseModel> getMastersList() throws SQLException {

        startConnection();

        PreparedStatement statement = null;

        List<MasterDatabaseModel> masters = new ArrayList<>();

        String getMastersQuery = "select * from masters;";

        try {

            statement = connection.prepareStatement(getMastersQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                masters.add(new MasterDatabaseModel(
                        UUID.fromString(resultSet.getString("master_id")),
                        resultSet.getString("master_phone_number"),
                        resultSet.getString("master_first_name"),
                        resultSet.getString("master_last_name"),
                        resultSet.getString("master_profile_description")
                ));
            }

            return masters;
        }catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public MasterDatabaseModel getMasterData(String masterId) throws SQLException {

        startConnection();

        PreparedStatement statement = null;

        MasterDatabaseModel master = null;

        String getMastersQuery = "select * from masters where master_id=?;";

        try {

            statement = connection.prepareStatement(getMastersQuery);

            statement.setString(1, masterId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                master = new MasterDatabaseModel(
                        UUID.fromString(resultSet.getString("master_id")),
                        resultSet.getString("master_phone_number"),
                        resultSet.getString("master_first_name"),
                        resultSet.getString("master_last_name"),
                        resultSet.getString("master_profile_description")
                );
            }

            return master;
        }catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void updateMasterData(String masterId, MasterDatabaseModel master) throws SQLException {

        startConnection();

        PreparedStatement statement = null;

        String getMastersQuery = "update masters" +
                " set master_first_name=?, master_last_name=?, master_profile_description=?" +
                " where master_id=?;";

        try {

            statement = connection.prepareStatement(getMastersQuery);

            statement.setString(1, master.getMasterFirstName());
            statement.setString(2, master.getMasterLastName());
            statement.setString(3, master.getMasterProfileDescription());
            statement.setString(4, masterId);

            statement.executeUpdate();

        }catch (SQLException e) {
            throw e;
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }
}
