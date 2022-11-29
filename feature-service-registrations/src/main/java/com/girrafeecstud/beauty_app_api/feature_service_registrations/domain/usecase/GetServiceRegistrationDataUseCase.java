package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;

public class GetServiceRegistrationDataUseCase {

    private ServiceRegistrationsRepository repository;

    public GetServiceRegistrationDataUseCase(ServiceRegistrationsRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getServiceRegistrationData(String serviceRegistrationId) {
        return repository.getServiceRegistrationData(serviceRegistrationId);
    }

}
