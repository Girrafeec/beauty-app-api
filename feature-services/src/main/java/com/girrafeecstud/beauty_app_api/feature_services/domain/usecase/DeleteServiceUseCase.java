package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class DeleteServiceUseCase {

    private ServicesRepository repository;

    public DeleteServiceUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult deleteService(String serviceId) {
        return repository.deleteService(serviceId);
    }
}
