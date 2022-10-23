package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.mapper.CustomerDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.datasource.CustomerRegistrationDataSourceImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @CustomerRegistrationDataSource
    @Scope("singleton")
    public UserRegistrationDataSource getCustomerRegistrationDataSoruceImpl(
            @CustomerRegistrationDao UserRegistrationDao dao,
            CustomerDatabaseMapper mapper
            ) {
        return new CustomerRegistrationDataSourceImpl(
                dao,
                mapper
        );
    }

}
