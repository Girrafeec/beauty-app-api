package com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.dto.MasterDto;

public class MasterEntityResponseDtoMapper implements EntityMapper<MasterEntity, MasterDto> {

    @Override
    public MasterDto mapFromEntity(MasterEntity type) {
        return new MasterDto(
                type.getMasterId(),
                type.getMasterPhoneNumber(),
                type.getMasterFirstName(),
                type.getMasterLastName(),
                type.getMasterProfileDescription()
        );
    }

    @Override
    public MasterEntity mapToEntity(MasterDto type) {
        return null;
    }
}
