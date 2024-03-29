package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.domain.entity.RegistationMasterEntity;
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
