package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;

public interface ServiceRegistrationsDataSource {

    BusinessResult addServiceRegistration(ServiceRegistrationEntity serviceRegistration);

    BusinessResult getCustomerServiceRegistrations(String customerId);

    BusinessResult getMasterServiceRegistrations(String masterId);

    BusinessResult getServiceRegistrationData(String serviceRegistrationId);

}
