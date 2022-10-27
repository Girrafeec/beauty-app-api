package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.entity.CustomerLoginEntity;
import org.json.JSONObject;

public class CustomerLoginJsonEntityMapper implements EntityMapper<CustomerLoginEntity, JSONObject> {

    @Override
    public JSONObject mapFromEntity(CustomerLoginEntity type) {
        return null;
    }

    @Override
    public CustomerLoginEntity mapToEntity(JSONObject type) {
        return new CustomerLoginEntity(
                type.getString("customerPhoneNumber"),
                type.getString("customerPassword")
        );
    }

}
