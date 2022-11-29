package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.dao.ServiceRegistrationsDao;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.mapper.ServiceRegistrationEntityDatabaseModelMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class ServiceRegistrationsDataSourceImpl implements ServiceRegistrationsDataSource {

    private ServiceRegistrationsDao dao;

    private ServiceRegistrationEntityDatabaseModelMapper mapper;

    public ServiceRegistrationsDataSourceImpl(
            ServiceRegistrationsDao dao,
            ServiceRegistrationEntityDatabaseModelMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult addServiceRegistration(ServiceRegistrationEntity serviceRegistration) {
        try {
            dao.addServiceRegistration(mapper.mapFromEntity(serviceRegistration));
            return new BusinessResult(
                    null,
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

    @Override
    public BusinessResult getCustomerServiceRegistrations(String customerId) {
        try {
            return new BusinessResult(
                    dao.getCustomerServiceRegistrations(customerId).stream().map( serviceRegistration ->
                            mapper.mapToEntity(serviceRegistration)
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

    @Override
    public BusinessResult getMasterServiceRegistrations(String masterId) {
        try {
            return new BusinessResult(
                    dao.getMasterServiceRegistrations(masterId).stream().map( serviceRegistration ->
                            mapper.mapToEntity(serviceRegistration)
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

    @Override
    public BusinessResult getServiceRegistrationData(String serviceRegistrationId) {
        try {
            return new BusinessResult(
                    mapper.mapToEntity(dao.getServiceRegistrationData(serviceRegistrationId)),
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
