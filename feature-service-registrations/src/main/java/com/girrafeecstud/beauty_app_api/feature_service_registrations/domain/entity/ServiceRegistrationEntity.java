package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceRegistrationEntity {

    private UUID serviceRegistrationId;

    private UUID customerId;

    private UUID serviceId;

    private LocalDateTime serviceRegistrationTimestamp;

    private String serviceRegistrationNote;

    public ServiceRegistrationEntity(
            UUID customerId,
            UUID serviceId,
            LocalDateTime serviceRegistrationTimestamp,
            String serviceRegistrationNote
    ) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceRegistrationTimestamp = serviceRegistrationTimestamp;
        this.serviceRegistrationNote = serviceRegistrationNote;
    }

    public ServiceRegistrationEntity(
            UUID serviceRegistrationId,
            UUID customerId,
            UUID serviceId,
            LocalDateTime serviceRegistrationTimestamp,
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

    public LocalDateTime getServiceRegistrationTimestamp() {
        return serviceRegistrationTimestamp;
    }

    public String getServiceRegistrationNote() {
        return serviceRegistrationNote;
    }
}
