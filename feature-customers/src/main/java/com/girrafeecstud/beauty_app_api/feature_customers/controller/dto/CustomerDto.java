package com.girrafeecstud.beauty_app_api.feature_customers.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CustomerDto {

    @JsonProperty("customerId")
    private UUID customerId;

    @JsonProperty("customerFirstName")
    private String customerFirstName;

    @JsonProperty("customerLastName")
    private String customerLastName;

    @JsonProperty("customerPhoneNumber")
    private String customerPhoneNumber;

    public CustomerDto(
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

}
