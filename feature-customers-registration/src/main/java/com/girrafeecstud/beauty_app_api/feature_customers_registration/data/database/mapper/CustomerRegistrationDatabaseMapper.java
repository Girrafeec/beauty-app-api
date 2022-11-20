package com.girrafeecstud.beauty_app_api.feature_customers_registration.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.domain.entity.RegistationCustomerEntity;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.data.database.model.CustomerDatabaseModelRegistration;

public class CustomerRegistrationDatabaseMapper implements EntityMapper<RegistationCustomerEntity, CustomerDatabaseModelRegistration> {

    public CustomerDatabaseModelRegistration mapFromEntity(RegistationCustomerEntity type) {
        return new CustomerDatabaseModelRegistration(
                type.getCustomerId(),
                type.getCustomerPhoneNumber(),
                type.getCustomerPassword(),
                type.getCustomerFirstName(),
                type.getCustomerLastName()
        );
    }

    public RegistationCustomerEntity mapToEntity(CustomerDatabaseModelRegistration type) {
        return new RegistationCustomerEntity(
                type.getCustomerId(),
                type.getCustomerPhoneNumber(),
                type.getCustomerFirstName(),
                type.getCustomerLastName()
        );
    }
}
