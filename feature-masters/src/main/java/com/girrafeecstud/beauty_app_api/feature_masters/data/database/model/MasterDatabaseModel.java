package com.girrafeecstud.beauty_app_api.feature_masters.data.database.model;

import java.util.UUID;

public class MasterDatabaseModel {

    private UUID masterId;

    private String masterPhoneNumber;

    private String masterFirstName;

    private String masterLastName;

    private String masterProfileDescription;

    public MasterDatabaseModel(
            UUID masterId,
            String masterPhoneNumber,
            String masterFirstName,
            String masterLastName,
            String masterProfileDescription
    ) {
        this.masterId = masterId;
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
        this.masterProfileDescription = masterProfileDescription;
    }

    public MasterDatabaseModel(String masterFirstName, String masterLastName, String masterProfileDescription) {
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
        this.masterProfileDescription = masterProfileDescription;
    }

    public UUID getMasterId() {
        return masterId;
    }

    public void setMasterId(UUID masterId) {
        this.masterId = masterId;
    }

    public String getMasterPhoneNumber() {
        return masterPhoneNumber;
    }

    public void setMasterPhoneNumber(String masterPhoneNumber) {
        this.masterPhoneNumber = masterPhoneNumber;
    }

    public String getMasterFirstName() {
        return masterFirstName;
    }

    public void setMasterFirstName(String masterFirstName) {
        this.masterFirstName = masterFirstName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

    public void setMasterLastName(String masterLastName) {
        this.masterLastName = masterLastName;
    }

    public String getMasterProfileDescription() {
        return masterProfileDescription;
    }

    public void setMasterProfileDescription(String masterProfileDescription) {
        this.masterProfileDescription = masterProfileDescription;
    }

}
