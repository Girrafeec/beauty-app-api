package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.entity;

import java.util.UUID;

public class MastersServiceRegistrationsEntity {

    private UUID masterId;

    private int masterServiceRegistrationsNumber;

    public MastersServiceRegistrationsEntity(
            UUID masterId,
            int masterServiceRegistrationsNumber
    ) {
        this.masterId = masterId;
        this.masterServiceRegistrationsNumber = masterServiceRegistrationsNumber;
    }

    public UUID getMasterId() {
        return masterId;
    }

    public int getMasterServiceRegistrationsNumber() {
        return masterServiceRegistrationsNumber;
    }

}
