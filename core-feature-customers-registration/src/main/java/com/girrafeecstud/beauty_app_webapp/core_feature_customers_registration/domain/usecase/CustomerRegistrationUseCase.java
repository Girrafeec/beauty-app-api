package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.usecase;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.Customer;

public class CustomerRegistrationUseCase {

    private UserRegistrationRepository repository;

    public CustomerRegistrationUseCase(
            @CustomerRegistrationRepository UserRegistrationRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessResult registration(Customer customer) {
        return repository.registration(customer);
    }

}
