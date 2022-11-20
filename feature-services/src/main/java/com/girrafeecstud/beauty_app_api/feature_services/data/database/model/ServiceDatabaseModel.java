package com.girrafeecstud.beauty_app_api.feature_services.data.database.model;

import java.util.UUID;

public class ServiceDatabaseModel {

    private UUID serviceID;

    private UUID masterID;

    private String serviceName;

    private String serviceDescription;

    private double servicePrice;

    private int serviceExecutionTime;

    public ServiceDatabaseModel(
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
            UUID masterID,
            String serviceName,
            String serviceDescription,
            double servicePrice,
            int serviceExecutionTime
    ) {
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
