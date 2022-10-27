package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.model.MasterLoginDatabaseModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class CustomerLoginDaoUnitTest {

    @Test
    public void testDatabaseUserExistsQuery() {
        MasterLoginDaoImpl dao = new MasterLoginDaoImpl();

        MasterLoginDatabaseModel customer = new MasterLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        boolean expectedResult = true;

        boolean actualResult = dao.userExists(customer);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDatabasePasswordMatchingQuery() {
        MasterLoginDaoImpl dao = new MasterLoginDaoImpl();

        MasterLoginDatabaseModel customer = new MasterLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        boolean expectedResult = true;

        boolean actualResult = dao.passwordMatches(customer);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDatabaseGetUserIdQuery() {
        MasterLoginDaoImpl dao = new MasterLoginDaoImpl();

        MasterLoginDatabaseModel customer = new MasterLoginDatabaseModel(
                "+79312315120",
                "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd"
        );

        MasterLoginDatabaseModel expectedResult = new MasterLoginDatabaseModel(
                UUID.fromString("d75b1f89-5379-11ed-8963-00f48dc19557")
        );

        MasterLoginDatabaseModel actualResult = (MasterLoginDatabaseModel) dao.getUserId(customer);

        Assert.assertEquals(expectedResult.getMasterId(), actualResult.getMasterId());
    }

}
