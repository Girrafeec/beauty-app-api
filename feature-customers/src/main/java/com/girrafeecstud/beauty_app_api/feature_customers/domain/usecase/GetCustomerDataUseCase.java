package com.girrafeecstud.beauty_app_api.feature_customers.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.repository.CustomersRepository;

public class GetCustomerDataUseCase {

    private CustomersRepository repository;

    public GetCustomerDataUseCase(CustomersRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getCustomerData(String customerId) {
        return repository.getCustomerData(customerId);
    }
}
