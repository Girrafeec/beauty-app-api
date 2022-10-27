package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.controller.mapper;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.controller.dto.MasterLoginDto;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity.MasterLoginEntity;

public class MasterLoginDtoMapper implements EntityMapper<MasterLoginEntity, MasterLoginDto> {

    @Override
    public MasterLoginDto mapFromEntity(MasterLoginEntity type) {
        return new MasterLoginDto(
                type.getMasterId()
        );
    }

    @Override
    public MasterLoginEntity mapToEntity(MasterLoginDto type) {
        return null;
    }
}
