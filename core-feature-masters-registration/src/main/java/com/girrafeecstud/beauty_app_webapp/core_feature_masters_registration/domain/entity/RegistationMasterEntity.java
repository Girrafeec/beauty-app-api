package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.domain.entity;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.RegistrationUserEntity;

import java.util.UUID;

public class RegistationMasterEntity implements RegistrationUserEntity {

    private UUID masterId;

    private String masterPhoneNumber;

    private String masterPassword;

    private String masterFirstName;

    private String masterLastName;

    public RegistationMasterEntity(
            String masterPhoneNumber,
            String masterPassword,
            String masterFirstName,
            String masterLastName
    ) {
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterPassword = masterPassword;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
    }

    public RegistationMasterEntity(
            UUID masterId,
            String masterPhoneNumber,
            String masterFirstName,
            String masterLastName
    ) {
        this.masterId = masterId;
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
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

    public String getMasterFirstName() {
        return masterFirstName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }
}
