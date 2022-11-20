package com.girrafeecstud.beauty_app_api.feature_services.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_services.data.database.model.ServiceDatabaseModel;

import java.sql.SQLException;
import java.util.List;

public interface ServicesDao {

    List<ServiceDatabaseModel> getServicesList() throws SQLException;

    ServiceDatabaseModel getServiceData(String serviceId) throws SQLException;

    List<ServiceDatabaseModel> getMasterServicesList(String masterId) throws SQLException;

    void addService(ServiceDatabaseModel service) throws SQLException;

    void updateService(ServiceDatabaseModel service, String serviceId) throws SQLException;

    void deleteService(String serviceId) throws SQLException;

}
