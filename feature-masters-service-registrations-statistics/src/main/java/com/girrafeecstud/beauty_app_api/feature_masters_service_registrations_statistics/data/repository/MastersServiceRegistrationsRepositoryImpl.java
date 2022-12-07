package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.datasource.MastersServiceRegistrationsDataSource;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.repository.MastersServiceRegistrationsRepository;

public class MastersServiceRegistrationsRepositoryImpl
        implements MastersServiceRegistrationsRepository {

    private MastersServiceRegistrationsDataSource dataSource;

    public MastersServiceRegistrationsRepositoryImpl(MastersServiceRegistrationsDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BusinessResult getMastersServiceRegistrations() {
        return dataSource.getMastersServiceRegistrations();
    }

}
