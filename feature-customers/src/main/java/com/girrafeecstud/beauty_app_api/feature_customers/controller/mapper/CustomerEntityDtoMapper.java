package com.girrafeecstud.beauty_app_api.feature_customers.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers.controller.dto.CustomerDto;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.entity.CustomerEntity;

public class CustomerEntityDtoMapper
        implements EntityMapper<CustomerEntity, CustomerDto> {

    @Override
    public CustomerDto mapFromEntity(CustomerEntity type) {
        return new CustomerDto(
                type.getCustomerId(),
                type.getCustomerFirstName(),
                type.getCustomerLastName(),
                type.getCustomerPhoneNumber()
        );
    }

    @Override
    public CustomerEntity mapToEntity(CustomerDto type) {
        return null;
    }
}
