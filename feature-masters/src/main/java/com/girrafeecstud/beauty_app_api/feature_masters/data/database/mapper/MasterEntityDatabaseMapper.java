package com.girrafeecstud.beauty_app_api.feature_masters.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.data.database.model.MasterDatabaseModel;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;

public class MasterEntityDatabaseMapper implements EntityMapper<MasterEntity, MasterDatabaseModel> {

    @Override
    public MasterDatabaseModel mapFromEntity(MasterEntity type) {
        return new MasterDatabaseModel(
                type.getMasterId(),
                type.getMasterPhoneNumber(),
                type.getMasterFirstName(),
                type.getMasterLastName(),
                type.getMasterProfileDescription()
        );
    }

    @Override
    public MasterEntity mapToEntity(MasterDatabaseModel type) {
        return new MasterEntity(
                type.getMasterId(),
                type.getMasterPhoneNumber(),
                type.getMasterFirstName(),
                type.getMasterLastName(),
                type.getMasterProfileDescription()
        );
    }
}
