package com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.model;

import com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.model.RegistrationUserDatabaseModel;

import java.util.UUID;

public class MasterDatabaseModelRegistration implements RegistrationUserDatabaseModel {

    private UUID masterId;

    private String masterPhoneNumber;

    private String masterHashedPassword;

    private String masterFirstName;

    private String masterLastName;

    public MasterDatabaseModelRegistration(
            String masterPhoneNumber,
            String masterHashedPassword,
            String masterFirstName,
            String masterLastName
    ) {
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterHashedPassword = masterHashedPassword;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
    }

    public MasterDatabaseModelRegistration(
            UUID customerId,
            String customerPhoneNumber,
            String masterHashedPassword,
            String masterFirstName,
            String masterLastName
    ) {
        this.masterId = customerId;
        this.masterPhoneNumber = customerPhoneNumber;
        this.masterHashedPassword = masterHashedPassword;
        this.masterFirstName = masterFirstName;
        this.masterLastName = masterLastName;
    }

    public MasterDatabaseModelRegistration(
            UUID customerId,
            String masterPhoneNumber,
            String masterFirstName,
            String masterLastName
    ) {
        this.masterId = customerId;
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

    public String getMasterHashedPassword() {
        return masterHashedPassword;
    }

    public String getMasterFirstName() {
        return masterFirstName;
    }

    public String getMasterLastName() {
        return masterLastName;
    }

}
