package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.usecase;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.annotation.CustomerLoginRepository;

public class CustomerLoginUseCase {

    private UserLoginRepository repository;

    public CustomerLoginUseCase(
           @CustomerLoginRepository UserLoginRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessResult login(LoginUserEntity user) {
        return repository.login(user);
    }

}
