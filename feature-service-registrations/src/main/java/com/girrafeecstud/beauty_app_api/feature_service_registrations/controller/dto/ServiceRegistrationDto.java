package com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceRegistrationDto {

    @JsonProperty("serviceRegistrationId")
    private UUID serviceRegistrationId;

    @JsonProperty("customerId")
    private UUID customerId;

    @JsonProperty("serviceId")
    private UUID serviceId;

    @JsonProperty("serviceTimestamp")
    private String serviceTimestamp;

    @JsonProperty("serviceNote")
    private String serviceNote;

    public ServiceRegistrationDto(
            UUID customerId,
            UUID serviceId,
            String serviceTimestamp,
            String serviceNote
    ) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceTimestamp = serviceTimestamp;
        this.serviceNote = serviceNote;
    }

    public ServiceRegistrationDto(
            UUID serviceRegistrationId,
            UUID customerId,
            UUID serviceId,
            String serviceTimestamp,
            String serviceNote
    ) {
        this.serviceRegistrationId = serviceRegistrationId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceTimestamp = serviceTimestamp;
        this.serviceNote = serviceNote;
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

    public String getServiceTimestamp() {
        return serviceTimestamp;
    }

    public String getServiceNote() {
        return serviceNote;
    }

}
