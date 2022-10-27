package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.model;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.model.LoginUserDatabaseModel;

import java.util.UUID;

public class MasterLoginDatabaseModel implements LoginUserDatabaseModel {

    private UUID masterId;

    private String masterPhoneNumber;

    private String masterHashedPassword;

    public MasterLoginDatabaseModel(String masterPhoneNumber, String masterHashedPassword) {
        this.masterPhoneNumber = masterPhoneNumber;
        this.masterHashedPassword = masterHashedPassword;
    }


    //TODO Remove?
    public MasterLoginDatabaseModel(UUID masterId) {
        this.masterId = masterId;
    }

    public MasterLoginDatabaseModel() {
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

    public void setMasterId(UUID masterId) {
        this.masterId = masterId;
    }
}
