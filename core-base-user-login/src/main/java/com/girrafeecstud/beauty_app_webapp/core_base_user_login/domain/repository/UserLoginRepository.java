package com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.repository;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.entity.LoginUserEntity;

public interface UserLoginRepository {
    BusinessResult login(LoginUserEntity loginUserEntity);

    boolean userExists(LoginUserEntity loginUserEntity);

}
