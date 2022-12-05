package com.girrafeecstud.beauty_app_api.feature_customers.domain.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;

public interface CustomersRepository {

    BusinessResult getCustomerData(String customerId);

}
