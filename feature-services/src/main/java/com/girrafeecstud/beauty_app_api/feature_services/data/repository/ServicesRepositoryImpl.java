package com.girrafeecstud.beauty_app_api.feature_services.data.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.data.datasource.ServicesDataSource;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class ServicesRepositoryImpl implements ServicesRepository {

    private ServicesDataSource dataSource;

    public ServicesRepositoryImpl(ServicesDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BusinessResult getServicesList() {
        return dataSource.getServicesList();
    }

    @Override
    public BusinessResult getServiceData(String serviceId) {
        return dataSource.getServiceData(serviceId);
    }

    @Override
    public BusinessResult getMasterServicesList(String masterId) {
        return dataSource.getMasterServicesList(masterId);
    }

    @Override
    public BusinessResult addService(ServiceEntity service) {
        return dataSource.addService(service);
    }

    @Override
    public BusinessResult updateServiceData(ServiceEntity service, String serviceId) {
        return dataSource.updateServiceData(service, serviceId);
    }

    @Override
    public BusinessResult deleteService(String serviceId) {
        return dataSource.deleteService(serviceId);
    }
}
