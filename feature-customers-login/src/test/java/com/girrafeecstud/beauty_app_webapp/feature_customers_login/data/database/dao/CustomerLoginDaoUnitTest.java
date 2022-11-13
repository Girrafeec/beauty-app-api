package com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.model.CustomerLoginDatabaseModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class CustomerLoginDaoUnitTest {

    @Test
    public void testDatabaseUserExistsQuery() {
        CustomerLoginDaoImpl dao = new CustomerLoginDaoImpl();

        CustomerLoginDatabaseModel customer = new CustomerLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        boolean expectedResult = true;

        boolean actualResult = dao.userExists(customer);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDatabasePasswordMatchingQuery() {
        CustomerLoginDaoImpl dao = new CustomerLoginDaoImpl();

        CustomerLoginDatabaseModel customer = new CustomerLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        boolean expectedResult = true;

        boolean actualResult = dao.passwordMatches(customer);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDatabaseGetUserIdQuery() {
        CustomerLoginDaoImpl dao = new CustomerLoginDaoImpl();

        CustomerLoginDatabaseModel customer = new CustomerLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        CustomerLoginDatabaseModel expectedResult = new CustomerLoginDatabaseModel(
                UUID.fromString("d75b1f89-5379-11ed-8963-00f48dc19557")
        );

        CustomerLoginDatabaseModel actualResult = (CustomerLoginDatabaseModel) dao.getUserId(customer);

        Assert.assertEquals(expectedResult.getCustomerId(), actualResult.getCustomerId());
    }

}
