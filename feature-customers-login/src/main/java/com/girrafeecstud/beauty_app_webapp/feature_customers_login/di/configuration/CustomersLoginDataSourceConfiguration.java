package com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.core_base_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.mapper.CustomerLoginDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.datasource.CustomerLoginDataSourceImpl;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.annotation.CustomerLoginDao;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.annotation.CustomerLoginDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersLoginDataSourceConfiguration {

    @Bean
    @CustomerLoginDataSource
    @Scope("singleton")
    public UserLoginDataSource getCustomerLoginDataSoruceImpl(
            @CustomerLoginDao UserLoginDao dao,
            CustomerLoginDatabaseMapper mapper
            ) {
        return new CustomerLoginDataSourceImpl(
                dao,
                mapper
        );
    }

}
