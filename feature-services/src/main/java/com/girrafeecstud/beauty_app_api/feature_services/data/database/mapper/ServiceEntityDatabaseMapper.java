package com.girrafeecstud.beauty_app_api.feature_services.data.database.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.model.ServiceDatabaseModel;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

public class ServiceEntityDatabaseMapper
        implements EntityMapper<ServiceEntity, ServiceDatabaseModel> {

    @Override
    public ServiceDatabaseModel mapFromEntity(ServiceEntity type) {
        return new ServiceDatabaseModel(
                type.getMasterID(),
                type.getServiceName(),
                type.getServiceDescription(),
                type.getServicePrice(),
                type.getServiceExecutionTime()
        );
    }

    @Override
    public ServiceEntity mapToEntity(ServiceDatabaseModel type) {
        return new ServiceEntity(
                type.getServiceID(),
                type.getMasterID(),
                type.getServiceName(),
                type.getServiceDescription(),
                type.getServicePrice(),
                type.getServiceExecutionTime()
        );
    }
}
