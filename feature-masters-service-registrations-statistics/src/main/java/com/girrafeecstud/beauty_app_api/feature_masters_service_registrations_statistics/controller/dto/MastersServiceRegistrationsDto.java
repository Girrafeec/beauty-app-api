package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class MastersServiceRegistrationsDto {

    @JsonProperty("masterId")
    private UUID masterId;

    @JsonProperty("masterServiceRegistrationsNumber")
    private int masterServiceRegistrationsNumber;

    public MastersServiceRegistrationsDto(
            UUID masterId,
            int masterServiceRegistratiosNumber
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
