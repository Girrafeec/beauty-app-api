package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.repository.CustomerRegistrationRepositoryImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersRegistrationRepositoryConfiguration {

    @Bean
    @CustomerRegistrationRepository
    @Scope("singleton")
    public UserRegistrationRepository getCustomerRegistrationRepositoryImpl(
            @CustomerRegistrationDataSource UserRegistrationDataSource dataSource,
            SHA256Hash sha256Hash
            ) {
        return new CustomerRegistrationRepositoryImpl(
                dataSource,
                sha256Hash
        );
    }

}
