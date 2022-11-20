package com.girrafeecstud.beauty_app_api.feature_masters_registration.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.domain.entity.RegistationMasterEntity;
import org.json.JSONObject;

public class MasterRegistrationJsonEntityMapper implements EntityMapper<RegistationMasterEntity, JSONObject> {

    @Override
    public JSONObject mapFromEntity(RegistationMasterEntity type) {
        return null;
    }

    @Override
    public RegistationMasterEntity mapToEntity(JSONObject type) {
        return new RegistationMasterEntity(
                type.getString("masterPhoneNumber"),
                type.getString("masterPassword"),
                type.getString("masterFirstName"),
                type.getString("masterLastName")
        );
    }

}
