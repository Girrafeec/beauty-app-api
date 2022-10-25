package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.model.UserDatabaseModel;

public interface UserRegistrationDao {
    void registration(UserDatabaseModel user);

    boolean userExists(UserDatabaseModel user);
}
