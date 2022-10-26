package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.database.mapper.CustomerDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public CustomerDatabaseMapper getCustomerDatabaseMapper() {
        return new CustomerDatabaseMapper();
    }

}
