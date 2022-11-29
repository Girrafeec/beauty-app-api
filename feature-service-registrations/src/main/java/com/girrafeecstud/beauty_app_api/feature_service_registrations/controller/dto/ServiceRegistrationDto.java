package com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ServiceRegistrationDto {

    @JsonProperty("serviceRegistrationId")
    private UUID serviceRegistrationId;

    @JsonProperty("customerId")
    private UUID customerId;

    @JsonProperty("serviceId")
    private UUID serviceId;

    @JsonProperty("serviceRegistrationTimestamp")
    private String serviceRegistrationTimestamp;

    @JsonProperty("serviceRegistrationNote")
    private String serviceRegistrationNote;

    public ServiceRegistrationDto() {}

    public ServiceRegistrationDto(
            UUID customerId,
            UUID serviceId,
            String serviceRegistrationTimestamp,
            String serviceRegistrationNote
    ) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceRegistrationTimestamp = serviceRegistrationTimestamp;
        this.serviceRegistrationNote = serviceRegistrationNote;
    }

    public ServiceRegistrationDto(
            UUID serviceRegistrationId,
            UUID customerId,
            UUID serviceId,
            String serviceRegistrationTimestamp,
            String serviceRegistrationNote
    ) {
        this.serviceRegistrationId = serviceRegistrationId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceRegistrationTimestamp = serviceRegistrationTimestamp;
        this.serviceRegistrationNote = serviceRegistrationNote;
    }

    public UUID getServiceRegistrationId() {
        return serviceRegistrationId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public String getServiceRegistrationTimestamp() {
        return serviceRegistrationTimestamp;
    }

    public String getServiceRegistrationNote() {
        return serviceRegistrationNote;
    }

}
