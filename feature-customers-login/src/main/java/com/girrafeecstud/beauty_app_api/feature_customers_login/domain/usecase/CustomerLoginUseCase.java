package com.girrafeecstud.beauty_app_api.feature_customers_login.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_api.core_base_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_api.feature_customers_login.di.annotation.CustomerLoginRepository;

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
