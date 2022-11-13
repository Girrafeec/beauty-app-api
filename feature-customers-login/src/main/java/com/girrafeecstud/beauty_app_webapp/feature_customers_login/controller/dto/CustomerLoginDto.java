package com.girrafeecstud.beauty_app_webapp.feature_customers_login.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CustomerLoginDto {

    @JsonProperty("customerId")
    public UUID customerId;

    public CustomerLoginDto(UUID customerId) {
        this.customerId = customerId;
    }
}
