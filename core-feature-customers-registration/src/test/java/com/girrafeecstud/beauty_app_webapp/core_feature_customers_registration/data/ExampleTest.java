package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao.CustomerRegistrationDaoImpl;
import org.junit.Test;

public class ExampleTest {

    @Test
    public void testDataBaseConnection() {
        CustomerRegistrationDaoImpl dao = new CustomerRegistrationDaoImpl();

        dao.registration(null);
    }

}
