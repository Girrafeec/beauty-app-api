package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.datasource.ServiceRegistrationsDataSource;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;

public class ServiceRegistrationsRepositoryImpl implements ServiceRegistrationsRepository {

    private ServiceRegistrationsDataSource dataSource;
    public ServiceRegistrationsRepositoryImpl(ServiceRegistrationsDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BusinessResult addServiceRegistration(ServiceRegistrationEntity serviceRegistration) {
        return dataSource.addServiceRegistration(serviceRegistration);
    }

    @Override
    public BusinessResult getCustomerServiceRegistrations(String customerId) {
        return dataSource.getCustomerServiceRegistrations(customerId);
    }

    @Override
    public BusinessResult getMasterServiceRegistrations(String masterId) {
        return dataSource.getMasterServiceRegistrations(masterId);
    }

    @Override
    public BusinessResult getServiceRegistrationData(String serviceRegistrationId) {
        return dataSource.getServiceRegistrationData(serviceRegistrationId);
    }

    @Override
    public BusinessResult deleteServiceRegistration(String serviceRegistrationId) {
        return null;
    }
}
