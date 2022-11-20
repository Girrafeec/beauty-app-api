package com.girrafeecstud.beauty_app_api.feature_services.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ServiceDto {

    @JsonProperty("serviceId")
    private UUID serviceId;

    @JsonProperty("masterId")
    private UUID masterId;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("serviceDescription")
    private String serviceDescription;

    @JsonProperty("servicePrice")
    private double servicePrice;

    @JsonProperty("serviceExecutionTime")
    private int serviceExecutionTime;

    public ServiceDto(
            UUID serviceId,
            UUID masterId,
            String serviceName,
            String serviceDescription,
            double servicePrice,
            int serviceExecutionTime
    ) {
        this.serviceId = serviceId;
        this.masterId = masterId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.serviceExecutionTime = serviceExecutionTime;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public UUID getMasterId() {
        return masterId;
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
