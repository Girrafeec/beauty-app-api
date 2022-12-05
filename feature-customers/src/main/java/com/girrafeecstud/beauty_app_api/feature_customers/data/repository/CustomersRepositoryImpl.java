package com.girrafeecstud.beauty_app_api.feature_customers.data.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_customers.data.datasource.CustomersDataSource;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.repository.CustomersRepository;

public class CustomersRepositoryImpl implements CustomersRepository {

    private CustomersDataSource dataSource;

    public CustomersRepositoryImpl(CustomersDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BusinessResult getCustomerData(String customerId) {
        return dataSource.getCustomerData(customerId);
    }
}
