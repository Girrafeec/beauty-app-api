package com.girrafeecstud.beauty_app_webapp.feature_customers_registration.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.feature_customers_registration.domain.entity.RegistationCustomerEntity;
import org.json.JSONObject;

public class CustomerRegistrationJsonEntityMapper implements EntityMapper<RegistationCustomerEntity, JSONObject> {

    @Override
    public JSONObject mapFromEntity(RegistationCustomerEntity type) {
        return null;
    }

    @Override
    public RegistationCustomerEntity mapToEntity(JSONObject type) {
        return new RegistationCustomerEntity(
                type.getString("customerPhoneNumber"),
                type.getString("customerPassword"),
                type.getString("customerFirstName"),
                type.getString("customerLastName")
        );
    }

}
