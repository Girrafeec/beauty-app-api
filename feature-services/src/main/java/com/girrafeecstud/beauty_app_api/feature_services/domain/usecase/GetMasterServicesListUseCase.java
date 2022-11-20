package com.girrafeecstud.beauty_app_api.feature_services.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;

public class GetMasterServicesListUseCase {

    private ServicesRepository repository;

    public GetMasterServicesListUseCase(ServicesRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getMasterServicesList(String masterId) {
        return repository.getMasterServicesList(masterId);
    }

}
