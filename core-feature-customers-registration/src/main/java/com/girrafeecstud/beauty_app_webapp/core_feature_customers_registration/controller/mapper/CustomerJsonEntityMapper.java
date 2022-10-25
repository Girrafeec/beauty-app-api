package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.Customer;
import org.json.JSONObject;

public class CustomerJsonEntityMapper implements EntityMapper<Customer, JSONObject> {

    @Override
    public JSONObject mapFromEntity(Customer type) {
        return null;
    }

    @Override
    public Customer mapToEntity(JSONObject type) {
        return new Customer(
                type.getString("customerPhoneNumber"),
                type.getString("customerPassword"),
                type.getString("customerFirstName"),
                type.getString("customerLastName")
        );
    }

}
