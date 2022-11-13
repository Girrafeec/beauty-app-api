package com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_webapp.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.dto.UpdateMasterDataRequestDto;

public class UpdateMasterRequestDtoEntityMapper implements
        EntityMapper<UpdateMasterDataRequestDto, MasterEntity> {

    @Override
    public MasterEntity mapFromEntity(UpdateMasterDataRequestDto type) {
        return new MasterEntity(
                type.getMasterFirstName(),
                type.getMasterLastName(),
                type.getMasterProfileDescription()
        );
    }

    @Override
    public UpdateMasterDataRequestDto mapToEntity(MasterEntity type) {
        return null;
    }
}
