package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.dao.CustomerRegistrationDaoImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfiguration {

    @Bean
    @CustomerRegistrationDao
    @Scope("singleton")
    public UserRegistrationDao getCustomerRegistrationDaoImpl() {
        return new CustomerRegistrationDaoImpl();
    }

}
