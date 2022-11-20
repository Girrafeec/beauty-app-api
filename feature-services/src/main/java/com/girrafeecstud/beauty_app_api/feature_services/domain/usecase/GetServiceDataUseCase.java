package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class GetServiceDataUseCase {

    private ServicesRepository repository;

    public GetServiceDataUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getServiceData(String serviceId) {
        return repository.getServiceData(serviceId);
    }

}
