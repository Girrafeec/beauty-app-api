package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;

public class GetCustomerServiceRegistrationsUseCase {

    private ServiceRegistrationsRepository repository;

    public GetCustomerServiceRegistrationsUseCase(ServiceRegistrationsRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getCustomerServiceRegistrations(String customerId) {
        return repository.getCustomerServiceRegistrations(customerId);
    }
}
