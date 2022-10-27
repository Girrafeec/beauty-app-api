package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.database.mapper.CustomerLoginDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public CustomerLoginDatabaseMapper getCustomerDatabaseMapper() {
        return new CustomerLoginDatabaseMapper();
    }

}
