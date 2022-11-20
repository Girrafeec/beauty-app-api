package com.girrafeecstud.beauty_app_api.feature_services.controller.dto;

import java.util.UUID;

public class ServiceDto {

    private UUID serviceID;

    private UUID masterID;

    private String serviceName;

    private String serviceDescription;

    private double servicePrice;

    private int serviceExecutionTime;

    public ServiceDto(
            UUID serviceID,
            UUID masterID,
            String serviceName,
            String serviceDescription,
            double servicePrice,
            int serviceExecutionTime
    ) {
        this.serviceID = serviceID;
        this.masterID = masterID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.serviceExecutionTime = serviceExecutionTime;
    }

    public UUID getServiceID() {
        return serviceID;
    }

    public UUID getMasterID() {
        return masterID;
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
