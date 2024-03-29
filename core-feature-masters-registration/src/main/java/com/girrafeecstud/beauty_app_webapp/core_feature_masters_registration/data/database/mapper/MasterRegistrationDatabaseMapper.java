package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.model.MasterDatabaseModelRegistration;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.domain.entity.RegistationMasterEntity;

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
