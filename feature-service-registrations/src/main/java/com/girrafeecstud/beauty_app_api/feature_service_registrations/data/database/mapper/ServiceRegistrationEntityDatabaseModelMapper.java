package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.model.ServiceRegistrationDatabaseModel;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;

public class ServiceRegistrationEntityDatabaseModelMapper
        implements EntityMapper<ServiceRegistrationEntity, ServiceRegistrationDatabaseModel> {

    @Override
    public ServiceRegistrationDatabaseModel mapFromEntity(ServiceRegistrationEntity type) {
        return new ServiceRegistrationDatabaseModel(
                type.getServiceRegistrationId(),
                type.getCustomerId(),
                type.getServiceId(),
                type.getServiceRegistrationTimestamp(),
                type.getServiceRegistrationNote()
        );
    }

    @Override
    public ServiceRegistrationEntity mapToEntity(ServiceRegistrationDatabaseModel type) {
        return new ServiceRegistrationEntity(
                type.getServiceRegistrationId(),
                type.getCustomerId(),
                type.getServiceId(),
                type.getServiceRegistrationTimestamp(),
                type.getServiceRegistrationNote()
        );
    }
}
