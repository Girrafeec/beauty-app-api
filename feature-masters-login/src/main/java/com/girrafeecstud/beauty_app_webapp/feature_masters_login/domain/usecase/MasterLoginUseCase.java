package com.girrafeecstud.beauty_app_webapp.feature_masters_login.domain.usecase;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.annotation.MasterLoginRepository;

public class MasterLoginUseCase {

    private UserLoginRepository repository;

    public MasterLoginUseCase(
           @MasterLoginRepository UserLoginRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessResult login(LoginUserEntity user) {
        return repository.login(user);
    }

}
