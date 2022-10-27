package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.model.LoginUserDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.model.MasterLoginDatabaseModel;

import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.UUID;

public class MasterLoginDaoImpl extends DatabaseConnection implements UserLoginDao {

    private Connection connection = null;

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

    @Override
    public boolean passwordMatches(LoginUserDatabaseModel user) {

        PreparedStatement statement = null;

        String loginQuery =
                "select if(master_password=?, true, false) as status" +
                        " from masters" +
                        " where (master_phone_number=?);";

        try {
            startConnection();

            statement = connection.prepareStatement(loginQuery);

            statement.setString(1, ((MasterLoginDatabaseModel) user).getMasterHashedPassword());
            statement.setString(2, ((MasterLoginDatabaseModel) user).getMasterPhoneNumber());

            ResultSet resultSet = statement.executeQuery();

            // Default value
            int passwordMatchesStatus = 0;

            while (resultSet.next())
                passwordMatchesStatus = resultSet.getInt("status");

            switch (passwordMatchesStatus){
                case 1:
                    return true;
                case 0:
                    return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection();
        }

        //TODO May cause error
        return false;
    }

    @Override
    public LoginUserDatabaseModel getUserId(LoginUserDatabaseModel user) {

        PreparedStatement statement = null;

        MasterLoginDatabaseModel customerDatabaseModel = new MasterLoginDatabaseModel();

        String query =
                "select master_id as master_id" +
                        " from masters" +
                        " where (master_phone_number=?);";

        try {
            startConnection();

            statement = connection.prepareStatement(query);

            statement.setString(
                    1,
                    ((MasterLoginDatabaseModel) user).getMasterPhoneNumber()
            );

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
                customerDatabaseModel.setMasterId(
                        UUID.fromString(resultSet.getString("master_id"))
                );

            return customerDatabaseModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection();
        }

        return customerDatabaseModel;
    }

    @Override
    public boolean userExists(LoginUserDatabaseModel user) {
        PreparedStatement statement = null;

        String checkIfUserExistsQuery = "select exists(select * from masters where master_phone_number=?) as status;";

        try {
            startConnection();

            statement = connection.prepareStatement(checkIfUserExistsQuery);

            statement.setString(
                    1,
                    ((MasterLoginDatabaseModel) user).getMasterPhoneNumber()
            );

            ResultSet resultSet = statement.executeQuery();

            // Default value
            int userExistsStatus = 0;

            while (resultSet.next())
                userExistsStatus = resultSet.getInt("status");

            switch (userExistsStatus){
                case 1:
                    return true;
                case 0:
                    return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnection();
        }

        //TODO May cause error
        return false;
    }

    @PreDestroy
    @Override
    public void onUserLoginDaoDestroy() {
        closeConnection();
    }
}
