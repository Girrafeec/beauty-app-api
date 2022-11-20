package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class GetServicesListUseCase {

    private ServicesRepository repository;

    public GetServicesListUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getServicesList() {
        return repository.getServicesList();
    }
}
