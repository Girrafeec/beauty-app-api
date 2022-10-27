package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.repository.CustomerLoginRepositoryImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.annotation.CustomerLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.annotation.CustomerLoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @CustomerLoginRepository
    @Scope("singleton")
    public UserLoginRepository getCustomerRegistrationRepositoryImpl(
            @CustomerLoginDataSource UserLoginDataSource dataSource,
            SHA256Hash sha256Hash
            ) {
        return new CustomerLoginRepositoryImpl(
                dataSource,
                sha256Hash
        );
    }

}
