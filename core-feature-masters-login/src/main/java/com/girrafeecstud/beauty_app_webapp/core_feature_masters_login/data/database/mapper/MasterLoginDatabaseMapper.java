package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.model.MasterLoginDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity.MasterLoginEntity;

public class MasterLoginDatabaseMapper implements EntityMapper<MasterLoginEntity, MasterLoginDatabaseModel> {

    @Override
    public MasterLoginDatabaseModel mapFromEntity(MasterLoginEntity type) {
        return new MasterLoginDatabaseModel(
                type.getMasterPhoneNumber(),
                type.getMasterPassword()
        );
    }

    @Override
    public MasterLoginEntity mapToEntity(MasterLoginDatabaseModel type) {
        return new MasterLoginEntity(
                type.getMasterId()
        );
    }
}
