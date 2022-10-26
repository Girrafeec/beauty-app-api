package com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.repository;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;

public interface UserLoginRepository {
    BusinessResult login(LoginUserEntity loginUserEntity);

    boolean userExists(LoginUserEntity loginUserEntity);

}
