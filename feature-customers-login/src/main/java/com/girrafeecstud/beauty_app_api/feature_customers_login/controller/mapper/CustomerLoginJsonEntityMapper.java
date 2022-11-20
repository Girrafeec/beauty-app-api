package com.girrafeecstud.beauty_app_api.feature_customers_login.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_login.domain.entity.CustomerLoginEntity;
import org.json.JSONObject;

public class CustomerLoginJsonEntityMapper implements EntityMapper<CustomerLoginEntity, JSONObject> {

    @Override
    public JSONObject mapFromEntity(CustomerLoginEntity type) {
        return new JSONObject(

        ).put("customerId", type.getCustomerId());
    }

    @Override
    public CustomerLoginEntity mapToEntity(JSONObject type) {
        return new CustomerLoginEntity(
                type.getString("customerPhoneNumber"),
                type.getString("customerPassword")
        );
    }

}
