package com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.model.RegistrationUserDatabaseModel;
import com.girrafeecstud.beauty_app_api.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.model.MasterDatabaseModelRegistration;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterRegistrationDaoImpl extends DatabaseConnection implements UserRegistrationDao {

    Connection connection = null;

    private void startConnection() {
        connection = getConnection();
    }

    @Override
    public void registration(RegistrationUserDatabaseModel user) {

        PreparedStatement statement = null;

        String sqlQuery = "INSERT INTO masters " +
                "(master_id, master_phone_number, master_password, master_first_name, master_last_name) " +
                "VALUES (uuid(), ?, ?, ?, ?);";

        try {
            startConnection();

            statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, ((MasterDatabaseModelRegistration) user).getMasterPhoneNumber());
            statement.setString(2, ((MasterDatabaseModelRegistration) user).getMasterHashedPassword());
            statement.setString(3, ((MasterDatabaseModelRegistration) user).getMasterFirstName());
            statement.setString(4, ((MasterDatabaseModelRegistration) user).getMasterLastName());

            statement.executeUpdate();
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public boolean userExists(RegistrationUserDatabaseModel user) {

        PreparedStatement statement = null;

        String checkIfUserExistsQuery = "select exists(select * from masters where master_phone_number=?) as status;";

        try {
            startConnection();

            statement = connection.prepareStatement(checkIfUserExistsQuery);

            statement.setString(1, ((MasterDatabaseModelRegistration) user).getMasterPhoneNumber());

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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        //TODO May cause error
        return false;
    }

    @PreDestroy
    @Override
    public void onUserRegistrationDaoDestroy() {
        System.out.println("destroy");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
