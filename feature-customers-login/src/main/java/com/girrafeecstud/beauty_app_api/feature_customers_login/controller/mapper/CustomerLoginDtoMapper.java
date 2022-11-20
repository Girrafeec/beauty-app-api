package com.girrafeecstud.beauty_app_api.feature_customers_login.controller.mapper;

import com.girrafeecstud.beauty_app_api.core_base.data.base.mapper.EntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_login.controller.dto.CustomerLoginDto;
import com.girrafeecstud.beauty_app_api.feature_customers_login.domain.entity.CustomerLoginEntity;

public class CustomerLoginDtoMapper implements EntityMapper<CustomerLoginEntity, CustomerLoginDto> {

    @Override
    public CustomerLoginDto mapFromEntity(CustomerLoginEntity type) {
        return new CustomerLoginDto(
                type.getCustomerId()
        );
    }

    @Override
    public CustomerLoginEntity mapToEntity(CustomerLoginDto type) {
        return null;
    }
}
