package com.girrafeecstud.beauty_app_api.feature_customers.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;

public interface CustomersDataSource {

    BusinessResult getCustomerData(String customerId);

}
