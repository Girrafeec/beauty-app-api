package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller.dto.MastersServiceRegistrationsDto;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.entity.MastersServiceRegistrationsEntity;

public class MastersServiceRegistrationsDtoEntityMapper
        implements EntityMapper<MastersServiceRegistrationsDto, MastersServiceRegistrationsEntity> {


    @Override
    public MastersServiceRegistrationsEntity mapFromEntity(MastersServiceRegistrationsDto type) {
        return null;
    }

    @Override
    public MastersServiceRegistrationsDto mapToEntity(MastersServiceRegistrationsEntity type) {
        return new MastersServiceRegistrationsDto(
                type.getMasterId(),
                type.getMasterServiceRegistrationsNumber()
        );
    }
}
