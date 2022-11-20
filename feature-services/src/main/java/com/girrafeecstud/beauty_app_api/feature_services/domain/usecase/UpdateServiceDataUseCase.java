package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class UpdateServiceDataUseCase {

    private ServicesRepository repository;

    public UpdateServiceDataUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult updateServiceData(ServiceEntity service, String serviceId) {
        return repository.updateServiceData(service, serviceId);
    }
}
