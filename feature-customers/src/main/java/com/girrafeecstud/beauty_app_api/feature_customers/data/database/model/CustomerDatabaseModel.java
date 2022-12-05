package com.girrafeecstud.beauty_app_api.feature_customers.data.database.model;

import java.util.UUID;

public class CustomerDatabaseModel {

    private UUID customerId;

    private String customerFirstName;

    private String customerLastName;

    private String customerPhoneNumber;

    public CustomerDatabaseModel(
            UUID customerId,
            String customerFirstName,
            String customerLastName,
            String customerPhoneNumber
    ) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }


}
