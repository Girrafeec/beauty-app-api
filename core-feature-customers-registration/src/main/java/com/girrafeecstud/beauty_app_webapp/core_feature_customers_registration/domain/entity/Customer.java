package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;

import java.util.UUID;

public class Customer implements User {

    private UUID customerId;

    private String customerPhoneNumber;

    private String customerPassword;

    private String customerFirstName;

    private String customerLastName;

    public Customer(
            String customerPhoneNumber,
            String customerPassword,
            String customerFirstName,
            String customerLastName
    ) {
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPassword = customerPassword;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public Customer(
            UUID customerId,
            String customerPhoneNumber,
            String customerFirstName,
            String customerLastName
    ) {
        this.customerId = customerId;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
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

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
