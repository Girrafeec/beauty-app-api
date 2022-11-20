package com.girrafeecstud.beauty_app_api.feature_services.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.dto.ServiceDto;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

public class ServiceDtoEntityMapper
        implements EntityMapper<ServiceEntity, ServiceDto> {

    @Override
    public ServiceDto mapFromEntity(ServiceEntity type) {
        return new ServiceDto(
                type.getServiceID(),
                type.getMasterID(),
                type.getServiceName(),
                type.getServiceDescription(),
                type.getServicePrice(),
                type.getServiceExecutionTime()
        );
    }

    @Override
    public ServiceEntity mapToEntity(ServiceDto type) {
        return null;
    }
}
