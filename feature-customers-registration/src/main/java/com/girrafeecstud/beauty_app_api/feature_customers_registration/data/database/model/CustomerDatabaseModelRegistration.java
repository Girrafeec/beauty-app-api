package com.girrafeecstud.beauty_app_api.feature_customers_registration.data.database.model;

import com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.model.RegistrationUserDatabaseModel;

import java.util.UUID;

public class CustomerDatabaseModelRegistration implements RegistrationUserDatabaseModel {

    private UUID customerId;

    private String customerPhoneNumber;

    private String customerHashedPassword;

    private String customerFirstName;

    private String customerLastName;

    public CustomerDatabaseModelRegistration(
            String customerPhoneNumber,
            String customerHashedPassword,
            String customerFirstName,
            String customerLastName
    ) {
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerHashedPassword = customerHashedPassword;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public CustomerDatabaseModelRegistration(
            UUID customerId,
            String customerPhoneNumber,
            String customerHashedPassword,
            String customerFirstName,
            String customerLastName
    ) {
        this.customerId = customerId;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerHashedPassword = customerHashedPassword;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public CustomerDatabaseModelRegistration(
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

    public String getCustomerHashedPassword() {
        return customerHashedPassword;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

}