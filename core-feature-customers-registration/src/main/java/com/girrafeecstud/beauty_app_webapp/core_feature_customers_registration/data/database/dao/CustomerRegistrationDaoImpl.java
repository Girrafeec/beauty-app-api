package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.model.UserDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_database.data.database.config.DatabaseConnection;

import java.sql.Connection;

public class CustomerRegistrationDaoImpl extends DatabaseConnection implements UserRegistrationDao {

    Connection connection = getConnection();

    public void registration(UserDatabaseModel user) {

    }

    // Add connection closing with @PreDestroy annotation

}
