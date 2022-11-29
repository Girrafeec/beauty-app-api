package com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceRegistrationDatabaseModel {

    private UUID serviceRegistrationId;

    private UUID customerId;

    private UUID serviceId;

    private LocalDateTime serviceRegistrationTimestamp;

    private String serviceRegistrationNote;

    public ServiceRegistrationDatabaseModel(
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
