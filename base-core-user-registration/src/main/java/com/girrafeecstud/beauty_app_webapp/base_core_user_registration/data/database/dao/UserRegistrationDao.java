package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.model.RegistrationUserDatabaseModel;

import javax.annotation.PreDestroy;

public interface UserRegistrationDao {
    void registration(RegistrationUserDatabaseModel user);

    boolean userExists(RegistrationUserDatabaseModel user);

    void onUserRegistrationDaoDestroy();
}
