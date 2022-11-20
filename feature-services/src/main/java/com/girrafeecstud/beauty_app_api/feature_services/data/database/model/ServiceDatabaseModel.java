package com.girrafeecstud.beauty_app_api.feature_services.data.database.model;

import java.util.UUID;

public class ServiceDatabaseModel {

    private UUID serviceId;

    private UUID masterId;

    private String serviceName;

    private String serviceDescription;

    private double servicePrice;

    private int serviceExecutionTime;

    public ServiceDatabaseModel(
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

    public ServiceDatabaseModel(
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

    public ServiceDatabaseModel(
            UUID masterId,
            String serviceName,
            String serviceDescription,
            double servicePrice,
            int serviceExecutionTime
    ) {
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
