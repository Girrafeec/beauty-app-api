package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.dao.MastersServiceRegistrationsDao;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.mapper.MastersServiceRegistrationsDatabaseEntityMapper;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class MastersServiceRegistrationsDataSourceImpl
        implements MastersServiceRegistrationsDataSource {

    private MastersServiceRegistrationsDao dao;

    private MastersServiceRegistrationsDatabaseEntityMapper mapper;

    public MastersServiceRegistrationsDataSourceImpl(
            MastersServiceRegistrationsDao dao,
            MastersServiceRegistrationsDatabaseEntityMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult getMastersServiceRegistrations() {
        try {
            return new BusinessResult(
                    dao.getMastersServiceRegistrations().stream().map( mastersServiceRegistration ->
                            mapper.mapToEntity(mastersServiceRegistration)
                    ).collect(Collectors.toList()),
                    null,
                    BusinessResultStatus.SUCCESS
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
    }

}
