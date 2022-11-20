package com.girrafeecstud.beauty_app_api.feature_services.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UpdateServiceRequestDto {

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("serviceDescription")
    private String serviceDescription;

    @JsonProperty("servicePrice")
    private double servicePrice;

    @JsonProperty("serviceExecutionTime")
    private int serviceExecutionTime;

    public UpdateServiceRequestDto(
            String serviceName,
            String serviceDescription,
            double servicePrice,
            int serviceExecutionTime
    ) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.serviceExecutionTime = serviceExecutionTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public int getServiceExecutionTime() {
        return serviceExecutionTime;
    }

}
