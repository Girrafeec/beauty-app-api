package com.girrafeecstud.beauty_app_api.feature_services.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.dto.AddNewServiceRequestDto;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

public class AddNewServiceRequestDtoEntityMapper
        implements EntityMapper<AddNewServiceRequestDto, ServiceEntity> {

    @Override
    public ServiceEntity mapFromEntity(AddNewServiceRequestDto type) {
        return new ServiceEntity(
                type.getMasterId(),
                type.getServiceName(),
                type.getServiceDescription(),
                type.getServicePrice(),
                type.getServiceExecutionTime()
        );
    }

    @Override
    public AddNewServiceRequestDto mapToEntity(ServiceEntity type) {
        return null;
    }
}
