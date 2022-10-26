package com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.model.LoginUserDatabaseModel;

public interface UserLoginDao {
    //TODO переписать под получение результата от БД
    void login(LoginUserDatabaseModel user);

    boolean userExists(LoginUserDatabaseModel user);

    void onUserLoginDaoDestroy();
}
