package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.model.CustomerDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.Customer;

public class CustomerDatabaseMapper implements EntityMapper<Customer, CustomerDatabaseModel> {

    public CustomerDatabaseModel mapFromEntity(Customer type) {
        return new CustomerDatabaseModel(
                type.getCustomerId(),
                type.getCustomerPhoneNumber(),
                type.getCustomerPassword(),
                type.getCustomerFirstName(),
                type.getCustomerLastName()
        );
    }

    public Customer mapToEntity(CustomerDatabaseModel type) {
        return new Customer(
                type.getCustomerId(),
                type.getCustomerPhoneNumber(),
                type.getCustomerFirstName(),
                type.getCustomerLastName()
        );
    }
}
