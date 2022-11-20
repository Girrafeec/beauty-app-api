package com.girrafeecstud.beauty_app_api.feature_services.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.dao.ServicesDao;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.mapper.ServiceEntityDatabaseMapper;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class ServicesDataSourceImpl implements ServicesDataSource {

    private ServicesDao dao;

    private ServiceEntityDatabaseMapper mapper;

    public ServicesDataSourceImpl(ServicesDao dao, ServiceEntityDatabaseMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult getServicesList() {
        try {
            return new BusinessResult(
                    dao.getServicesList().stream().map( service ->
                            mapper.mapToEntity(service)
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
    public BusinessResult getServiceData(String serviceId) {
        try {
            return new BusinessResult(
                    mapper.mapToEntity(dao.getServiceData(serviceId)),
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
    public BusinessResult getMasterServicesList(String masterId) {
        try {
            return new BusinessResult(
                    dao.getMasterServicesList(masterId).stream().map( service ->
                            mapper.mapToEntity(service)
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
    public BusinessResult addService(ServiceEntity service) {
        try {
            dao.addService(mapper.mapFromEntity(service));
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
    public BusinessResult updateServiceData(ServiceEntity service, String serviceId) {
        try {
            dao.updateService(
                    mapper.mapFromEntity(service),
                    serviceId
            );
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
    public BusinessResult deleteService(String serviceId) {
        try {
            dao.deleteService(serviceId);
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
}
