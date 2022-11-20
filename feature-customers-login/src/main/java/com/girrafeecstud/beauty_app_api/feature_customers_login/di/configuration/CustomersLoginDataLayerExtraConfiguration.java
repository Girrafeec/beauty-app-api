package com.girrafeecstud.beauty_app_api.feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_api.feature_customers_login.data.database.mapper.CustomerLoginDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersLoginDataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public CustomerLoginDatabaseMapper getLoginCustomerDatabaseMapper() {
        return new CustomerLoginDatabaseMapper();
    }

}
