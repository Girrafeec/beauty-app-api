package com.girrafeecstud.beauty_app_api.feature_services.domain.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;

public interface ServicesRepository {

    BusinessResult getServicesList();

    BusinessResult getServiceData(String serviceId);

    BusinessResult getMasterServicesList(String masterId);

    BusinessResult addService(ServiceEntity service);

    BusinessResult updateServiceData(ServiceEntity service, String serviceId);

    BusinessResult deleteService(String serviceId);

}
