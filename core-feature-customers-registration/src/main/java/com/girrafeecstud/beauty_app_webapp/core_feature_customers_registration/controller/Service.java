package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.controller;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao.CustomerRegistrationDaoImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration.CustomerRegistrationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Service {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        CustomerRegistrationConfiguration.class
                );

        CustomerRegistrationDaoImpl dao = context.getBean(CustomerRegistrationDaoImpl.class);

        dao.registration(null);

        context.close();
    }

}
