package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.entity;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;

import java.util.UUID;

public class CustomerLoginEntity implements LoginUserEntity {

    private UUID customerId;

    private String customerPhoneNumber;

    private String customerPassword;

    public CustomerLoginEntity(String customerPhoneNumber, String customerPassword) {
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPassword = customerPassword;
    }


    //TODO Remove?
    public CustomerLoginEntity(UUID customerId) {
        this.customerId = customerId;
    }

    public CustomerLoginEntity() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
