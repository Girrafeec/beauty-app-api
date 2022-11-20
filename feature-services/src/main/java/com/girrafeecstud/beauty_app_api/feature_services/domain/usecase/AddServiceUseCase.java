package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class AddServiceUseCase {

    private ServicesRepository repository;

    public AddServiceUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult addService(ServiceEntity service) {
        return repository.addService(service);
    }
}
