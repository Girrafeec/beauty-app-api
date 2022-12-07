package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.repository.MastersServiceRegistrationsRepository;

public class GetMastersServiceRegistrationsUseCase {

    private MastersServiceRegistrationsRepository repository;

    public GetMastersServiceRegistrationsUseCase(MastersServiceRegistrationsRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getMastersServiceRegistrations() {
        return repository.getMastersServiceRegistrations();
    }
}
