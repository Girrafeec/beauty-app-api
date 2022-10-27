package com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.model.LoginUserDatabaseModel;

public interface UserLoginDao {
    //TODO переписать под получение результата от БД
    boolean passwordMatches(LoginUserDatabaseModel user);

    LoginUserDatabaseModel getUserId(LoginUserDatabaseModel user);

    boolean userExists(LoginUserDatabaseModel user);

    void onUserLoginDaoDestroy();
}
