package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;

public interface ServiceRegistrationsRepository {

    BusinessResult addServiceRegistration(ServiceRegistrationEntity serviceRegistration);

    BusinessResult getCustomerServiceRegistrations(String customerId);

    BusinessResult getMasterServiceRegistrations(String masterId);

    BusinessResult getServiceRegistrationData(String serviceRegistrationId);

    BusinessResult deleteServiceRegistration(String serviceRegistrationId);

}
