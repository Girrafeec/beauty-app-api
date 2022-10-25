package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao.CustomerRegistrationDaoImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.model.CustomerDatabaseModel;
import org.junit.Assert;
import org.junit.Test;

public class CustomerRegistrationDaoUnitTest {

    @Test
    public void testDataBaseConnection() {
        CustomerRegistrationDaoImpl dao = new CustomerRegistrationDaoImpl();

        dao.registration(null);
    }

    @Test
    public void testDataBaseUserExistsQuery() {
        CustomerRegistrationDaoImpl dao = new CustomerRegistrationDaoImpl();

        CustomerDatabaseModel customer = new CustomerDatabaseModel(
                "+79312315120",
                "qwertyuiop",
                "Ivan",
                "Zalesskii"
        );

        boolean expectedResult = true;

        boolean actualResult = dao.userExists(customer);

        Assert.assertEquals(expectedResult, actualResult);
    }

}
