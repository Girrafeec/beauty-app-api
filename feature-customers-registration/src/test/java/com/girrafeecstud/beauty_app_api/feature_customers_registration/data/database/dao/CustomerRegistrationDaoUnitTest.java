package com.girrafeecstud.beauty_app_api.feature_customers_registration.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_customers_registration.data.database.model.CustomerDatabaseModelRegistration;
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

        CustomerDatabaseModelRegistration customer = new CustomerDatabaseModelRegistration(
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
