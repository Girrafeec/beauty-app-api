package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.model.MasterDatabaseModelRegistration;
import org.junit.Assert;
import org.junit.Test;

public class MasterRegistrationDaoUnitTest {

    @Test
    public void testDataBaseConnection() {
        MasterRegistrationDaoImpl dao = new MasterRegistrationDaoImpl();

        dao.registration(null);
    }

    @Test
    public void testDataBaseUserExistsQuery() {
        MasterRegistrationDaoImpl dao = new MasterRegistrationDaoImpl();

        MasterDatabaseModelRegistration customer = new MasterDatabaseModelRegistration(
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
