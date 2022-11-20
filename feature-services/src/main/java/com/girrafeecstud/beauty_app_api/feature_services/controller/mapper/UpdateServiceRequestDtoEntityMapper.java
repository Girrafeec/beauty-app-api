package com.girrafeecstud.beauty_app_api.feature_services.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.dto.UpdateServiceRequestDto;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

public class UpdateServiceRequestDtoEntityMapper
        implements EntityMapper<ServiceEntity, UpdateServiceRequestDto> {

    @Override
    public UpdateServiceRequestDto mapFromEntity(ServiceEntity type) {
        return null;
    }

    @Override
    public ServiceEntity mapToEntity(UpdateServiceRequestDto type) {
        return new ServiceEntity(
                type.getServiceName(),
                type.getServiceDescription(),
                type.getServicePrice(),
                type.getServiceExecutionTime()
        );
    }
}
