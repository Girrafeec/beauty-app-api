package com.girrafeecstud.beauty_app_api.feature_masters.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateMasterDataRequestDto {

    @JsonProperty("masterFirstName")
    private String masterFirstName;

    @JsonProperty("masterLastName")
    private String masterLastName;

    @JsonProperty("masterProfileDescription")
    private String masterProfileDescription;

    public UpdateMasterDataRequestDto(String masterFirstName, String masterLastName, String masterProfileDescription) {
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
        this.masterProfileDescription = masterProfileDescription;
    }

    public String getMasterFirstName() {
        return masterFirstName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

    public String getMasterProfileDescription() {
        return masterProfileDescription;
    }
}
