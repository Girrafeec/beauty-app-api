package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.usecase.CustomerRegistrationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersRegistrationUseCaseConfiguration {
    @Bean
    @Scope("singleton")
    public CustomerRegistrationUseCase getCustomerRegistrationUseCase(
            @CustomerRegistrationRepository UserRegistrationRepository repository
    ) {
        return new CustomerRegistrationUseCase(repository);
    }
}
