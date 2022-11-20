package com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.domain.entity.RegistationMasterEntity;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.model.MasterDatabaseModelRegistration;

public class MasterRegistrationDatabaseMapper implements EntityMapper<RegistationMasterEntity, MasterDatabaseModelRegistration> {

    public MasterDatabaseModelRegistration mapFromEntity(RegistationMasterEntity type) {
        return new MasterDatabaseModelRegistration(
                type.getMasterId(),
                type.getMasterPhoneNumber(),
                type.getMasterPassword(),
                type.getMasterFirstName(),
                type.getMasterLastName()
        );
    }

    public RegistationMasterEntity mapToEntity(MasterDatabaseModelRegistration type) {
        return new RegistationMasterEntity(
                type.getMasterId(),
                type.getMasterPhoneNumber(),
                type.getMasterFirstName(),
                type.getMasterLastName()
        );
    }
}
