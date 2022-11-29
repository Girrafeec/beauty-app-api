package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;

public class AddServiceRegistrationUseCase {

    private ServiceRegistrationsRepository repository;

    public AddServiceRegistrationUseCase(ServiceRegistrationsRepository repository) {
        this.repository = repository;
    }

    public BusinessResult addServiceRegistration(ServiceRegistrationEntity serviceRegistration) {
        return repository.addServiceRegistration(serviceRegistration);
    }

}
