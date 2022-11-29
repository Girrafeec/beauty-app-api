package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;

public class GetMasterServiceRegistrationsUseCase {

    private ServiceRegistrationsRepository repository;

    public GetMasterServiceRegistrationsUseCase(ServiceRegistrationsRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getMasterServiceRegistrations(String masterId) {
        return repository.getMasterServiceRegistrations(masterId);
    }

}
