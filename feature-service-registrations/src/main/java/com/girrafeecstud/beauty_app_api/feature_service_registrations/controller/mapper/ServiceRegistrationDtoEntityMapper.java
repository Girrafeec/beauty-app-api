package com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.dto.ServiceRegistrationDto;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;

import java.time.LocalDateTime;

public class ServiceRegistrationDtoEntityMapper
        implements EntityMapper<ServiceRegistrationDto, ServiceRegistrationEntity> {

    @Override
    public ServiceRegistrationEntity mapFromEntity(ServiceRegistrationDto type) {
        return new ServiceRegistrationEntity(
                type.getCustomerId(),
                type.getServiceId(),
                LocalDateTime.parse(type.getServiceRegistrationTimestamp()),
                type.getServiceRegistrationNote()
        );
    }

    @Override
    public ServiceRegistrationDto mapToEntity(ServiceRegistrationEntity type) {
        return new ServiceRegistrationDto(
                type.getServiceRegistrationId(),
                type.getCustomerId(),
                type.getServiceId(),
                type.getServiceRegistrationTimestamp().toString(),
                type.getServiceRegistrationNote()
        );
    }
}
