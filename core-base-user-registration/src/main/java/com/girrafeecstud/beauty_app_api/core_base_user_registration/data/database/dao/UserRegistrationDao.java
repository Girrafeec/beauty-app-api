package com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.dao;

import com.girrafeecstud.beauty_app_api.core_base_user_registration.data.database.model.RegistrationUserDatabaseModel;

public interface UserRegistrationDao {
    void registration(RegistrationUserDatabaseModel user);

    boolean userExists(RegistrationUserDatabaseModel user);

    void onUserRegistrationDaoDestroy();
}
