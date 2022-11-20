package com.girrafeecstud.beauty_app_api.feature_customers_registration.di.configuration;

import com.girrafeecstud.beauty_app_api.core_base_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.domain.usecase.CustomerRegistrationUseCase;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.di.annotation.CustomerRegistrationRepository;
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
