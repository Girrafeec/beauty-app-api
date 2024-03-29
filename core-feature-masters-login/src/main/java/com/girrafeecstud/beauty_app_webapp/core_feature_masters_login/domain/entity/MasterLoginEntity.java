package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;

import java.util.UUID;

public class MasterLoginEntity implements LoginUserEntity {

    private UUID masterId;

    private String masterPhoneNumber;

    private String masterPassword;

    public MasterLoginEntity(String masterPhoneNumber, String masterPassword) {
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterPassword = masterPassword;
    }


    //TODO Remove?
    public MasterLoginEntity(UUID masterId) {
        this.masterId = masterId;
    }

    public MasterLoginEntity() {
    }

    public UUID getMasterId() {
        return masterId;
    }

    public String getMasterPhoneNumber() {
        return masterPhoneNumber;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterId(UUID masterId) {
        this.masterId = masterId;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }
}
