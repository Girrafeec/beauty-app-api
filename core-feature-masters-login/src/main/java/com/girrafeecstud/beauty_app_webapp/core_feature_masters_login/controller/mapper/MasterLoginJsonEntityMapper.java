package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity.MasterLoginEntity;
import org.json.JSONObject;

public class MasterLoginJsonEntityMapper implements EntityMapper<MasterLoginEntity, JSONObject> {

    @Override
    public JSONObject mapFromEntity(MasterLoginEntity type) {
        return new JSONObject(

        ).put("masterId", type.getMasterId());
    }

    @Override
    public MasterLoginEntity mapToEntity(JSONObject type) {
        return new MasterLoginEntity(
                type.getString("masterPhoneNumber"),
                type.getString("masterPassword")
        );
    }

}
