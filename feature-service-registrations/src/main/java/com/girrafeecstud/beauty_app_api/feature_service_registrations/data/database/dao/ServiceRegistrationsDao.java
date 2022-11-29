package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.model.ServiceRegistrationDatabaseModel;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRegistrationsDao {

    void addServiceRegistration(ServiceRegistrationDatabaseModel serviceRegistration) throws SQLException;

    List<ServiceRegistrationDatabaseModel> getCustomerServiceRegistrations(String customerId) throws SQLException;

    List<ServiceRegistrationDatabaseModel> getMasterServiceRegistrations(String masterId) throws SQLException;

    ServiceRegistrationDatabaseModel getServiceRegistrationData(String serviceRegistrationId) throws SQLException;

}
