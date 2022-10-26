package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.model.CustomerDatabaseModelRegistration;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.RegistationCustomerEntity;

public class CustomerDatabaseMapper implements EntityMapper<RegistationCustomerEntity, CustomerDatabaseModelRegistration> {

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
