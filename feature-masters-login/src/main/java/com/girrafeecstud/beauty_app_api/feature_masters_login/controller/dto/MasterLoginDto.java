package com.girrafeecstud.beauty_app_api.feature_masters_login.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class MasterLoginDto {

    @JsonProperty("masterId")
    public UUID masterId;

    public MasterLoginDto(UUID masterId) {
        this.masterId = masterId;
    }
}
