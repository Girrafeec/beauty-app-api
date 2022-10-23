package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.repository;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.Customer;

public class CustomerRegistrationRepositoryImpl implements UserRegistrationRepository {

    private UserRegistrationDataSource dataSource;

    private SHA256Hash sha256Hash;

    public CustomerRegistrationRepositoryImpl(
            @CustomerRegistrationDataSource UserRegistrationDataSource dataSource,
            SHA256Hash sha256Hash
    ) {
        this.dataSource = dataSource;
        this.sha256Hash = sha256Hash;
    }

    public void registration(User user) {
        Customer customer = (Customer) user;
        customer.setCustomerPassword(sha256Hash.getSHA256Hash(customer.getCustomerPassword()));
        dataSource.registration(customer);
    }

}
