package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.model.MastersServiceRegistrationsDatabaseModel;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.entity.MastersServiceRegistrationsEntity;

public class MastersServiceRegistrationsDatabaseEntityMapper
        implements EntityMapper<MastersServiceRegistrationsEntity, MastersServiceRegistrationsDatabaseModel> {

    @Override
    public MastersServiceRegistrationsDatabaseModel mapFromEntity(MastersServiceRegistrationsEntity type) {
        return null;
    }

    @Override
    public MastersServiceRegistrationsEntity mapToEntity(MastersServiceRegistrationsDatabaseModel type) {
        return new MastersServiceRegistrationsEntity(
                type.getMasterId(),
                type.getMasterServiceRegistrationsNumber()
        );
    }

}
