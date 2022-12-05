package com.girrafeecstud.beauty_app_api.feature_customers.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.model.CustomerDatabaseModel;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.entity.CustomerEntity;

public class CustomerDatabaseEntityMapper
        implements EntityMapper<CustomerEntity, CustomerDatabaseModel> {

    @Override
    public CustomerDatabaseModel mapFromEntity(CustomerEntity type) {
        return null;
    }

    @Override
    public CustomerEntity mapToEntity(CustomerDatabaseModel type) {
        return new CustomerEntity(
                type.getCustomerId(),
                type.getCustomerFirstName(),
                type.getCustomerLastName(),
                type.getCustomerPhoneNumber()
        );
    }
}
