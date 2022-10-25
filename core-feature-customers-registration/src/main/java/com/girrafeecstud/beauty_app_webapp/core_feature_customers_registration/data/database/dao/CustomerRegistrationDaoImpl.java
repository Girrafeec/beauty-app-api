package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.model.UserDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_database.data.database.config.DatabaseConnection;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.model.CustomerDatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomerRegistrationDaoImpl extends DatabaseConnection implements UserRegistrationDao {

    //TODO move connection to dao methods?
    Connection connection = getConnection();

    @Override
    public void registration(UserDatabaseModel user) {

        PreparedStatement statement = null;

        CustomerDatabaseModel customerDatabaseModel = (CustomerDatabaseModel) user;

        String sqlQuery = "INSERT INTO customers " +
                "(customer_id, customer_phone_number, customer_password, customer_first_name, customer_last_name) " +
                "VALUES (uuid(), ?, ?, ?, ?);";

        try {
            statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, customerDatabaseModel.getCustomerPhoneNumber());
            statement.setString(2, customerDatabaseModel.getCustomerHashedPassword());
            statement.setString(3, customerDatabaseModel.getCustomerFirstName());
            statement.setString(4, customerDatabaseModel.getCustomerLastName());

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
    public boolean userExists(UserDatabaseModel user) {

        PreparedStatement statement = null;

        CustomerDatabaseModel customerDatabaseModel = (CustomerDatabaseModel) user;

        String checkIfUserExistsQuery = "select exists(select * from customers where customer_phone_number=?) as status;";

        try {
            statement = connection.prepareStatement(checkIfUserExistsQuery);

            statement.setString(1, customerDatabaseModel.getCustomerPhoneNumber());

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
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        //TODO May cause error
        return false;
    }

    //TODO Add connection closing with @PreDestroy annotation


}
