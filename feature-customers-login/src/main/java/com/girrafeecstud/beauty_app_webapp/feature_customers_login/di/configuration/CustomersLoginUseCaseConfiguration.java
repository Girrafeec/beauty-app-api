package com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.annotation.CustomerLoginRepository;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.domain.usecase.CustomerLoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersLoginUseCaseConfiguration {
    @Bean
    @Scope("singleton")
    public CustomerLoginUseCase getCustomerLoginUseCase(
            @CustomerLoginRepository UserLoginRepository repository
    ) {
        return new CustomerLoginUseCase(repository);
    }
}
