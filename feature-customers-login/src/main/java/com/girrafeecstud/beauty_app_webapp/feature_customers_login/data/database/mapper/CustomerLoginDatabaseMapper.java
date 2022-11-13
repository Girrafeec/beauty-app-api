package com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.mapper;

import com.girrafeecstud.beauty_app_webapp.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.model.CustomerLoginDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.domain.entity.CustomerLoginEntity;

public class CustomerLoginDatabaseMapper implements EntityMapper<CustomerLoginEntity, CustomerLoginDatabaseModel> {

    @Override
    public CustomerLoginDatabaseModel mapFromEntity(CustomerLoginEntity type) {
        return new CustomerLoginDatabaseModel(
                type.getCustomerPhoneNumber(),
                type.getCustomerPassword()
        );
    }

    @Override
    public CustomerLoginEntity mapToEntity(CustomerLoginDatabaseModel type) {
        return new CustomerLoginEntity(
                type.getCustomerId()
        );
    }
}
