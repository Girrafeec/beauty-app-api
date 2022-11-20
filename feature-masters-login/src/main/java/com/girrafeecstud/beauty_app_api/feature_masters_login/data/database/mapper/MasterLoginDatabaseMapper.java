package com.girrafeecstud.beauty_app_api.feature_masters_login.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_login.domain.entity.MasterLoginEntity;
import com.girrafeecstud.beauty_app_api.feature_masters_login.data.database.model.MasterLoginDatabaseModel;

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
