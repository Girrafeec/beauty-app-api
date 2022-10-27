package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.mapper.CustomerRegistrationDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersRegistrationDataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public CustomerRegistrationDatabaseMapper getCustomerDatabaseMapper() {
        return new CustomerRegistrationDatabaseMapper();
    }

}
