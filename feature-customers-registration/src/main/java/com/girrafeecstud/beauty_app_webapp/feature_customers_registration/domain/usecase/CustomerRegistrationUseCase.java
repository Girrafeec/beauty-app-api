package com.girrafeecstud.beauty_app_webapp.feature_customers_registration.domain.usecase;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_base_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.feature_customers_registration.di.annotation.CustomerRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.feature_customers_registration.domain.entity.RegistationCustomerEntity;

public class CustomerRegistrationUseCase {

    private UserRegistrationRepository repository;

    public CustomerRegistrationUseCase(
            @CustomerRegistrationRepository UserRegistrationRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessResult registration(RegistationCustomerEntity customer) {
        return repository.registration(customer);
    }

}
