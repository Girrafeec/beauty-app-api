package com.girrafeecstud.beauty_app_api.feature_customers_login.data.database.model;

import com.girrafeecstud.beauty_app_api.core_base_user_login.data.database.model.LoginUserDatabaseModel;

import java.util.UUID;

public class CustomerLoginDatabaseModel implements LoginUserDatabaseModel {

    private UUID customerId;

    private String customerPhoneNumber;

    private String customerHashedPassword;

    public CustomerLoginDatabaseModel(String customerPhoneNumber, String customerHashedPassword) {
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerHashedPassword = customerHashedPassword;
    }


    //TODO Remove?
    public CustomerLoginDatabaseModel(UUID customerId) {
        this.customerId = customerId;
    }

    public CustomerLoginDatabaseModel() {
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

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
