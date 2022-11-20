package com.girrafeecstud.beauty_app_api.core_base_user_login.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base_user_login.domain.entity.LoginUserEntity;

public interface UserLoginDataSource {
    BusinessResult login(LoginUserEntity loginUserEntity);

    boolean userExists(LoginUserEntity loginUserEntity);
}
