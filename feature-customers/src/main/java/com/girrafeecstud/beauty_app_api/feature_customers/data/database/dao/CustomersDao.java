package com.girrafeecstud.beauty_app_api.feature_customers.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_customers.data.database.model.CustomerDatabaseModel;

import java.sql.SQLException;

public interface CustomersDao {

    CustomerDatabaseModel getCustomerData(String customerId) throws SQLException;

}
