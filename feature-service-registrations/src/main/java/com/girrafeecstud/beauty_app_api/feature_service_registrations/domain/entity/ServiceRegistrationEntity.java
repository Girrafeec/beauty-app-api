package com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceRegistrationEntity {

    private UUID serviceRegistrationId;

    private UUID customerId;

    private UUID serviceId;

    private LocalDateTime serviceTimestamp;

    private String serviceNote;

    public ServiceRegistrationEntity(
            UUID customerId,
            UUID serviceId,
            LocalDateTime serviceTimestamp,
            String serviceNote
    ) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceTimestamp = serviceTimestamp;
        this.serviceNote = serviceNote;
    }

    public ServiceRegistrationEntity(
            UUID serviceRegistrationId,
            UUID customerId,
            UUID serviceId,
            LocalDateTime serviceTimestamp,
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

    public LocalDateTime getServiceTimestamp() {
        return serviceTimestamp;
    }

    public String getServiceNote() {
        return serviceNote;
    }
}
