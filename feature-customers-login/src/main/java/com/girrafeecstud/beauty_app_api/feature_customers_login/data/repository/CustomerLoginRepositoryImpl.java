package com.girrafeecstud.beauty_app_api.feature_customers_login.data.repository;

import com.girrafeecstud.beauty_app_api.core_base.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.error.DomainErrors;
import com.girrafeecstud.beauty_app_api.core_base_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_api.core_base_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_api.core_base_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_api.feature_customers_login.di.annotation.CustomerLoginDataSource;
import com.girrafeecstud.beauty_app_api.feature_customers_login.domain.entity.CustomerLoginEntity;

public class CustomerLoginRepositoryImpl implements UserLoginRepository {

    private UserLoginDataSource dataSource;

    private SHA256Hash sha256Hash;

    public CustomerLoginRepositoryImpl(
            @CustomerLoginDataSource UserLoginDataSource dataSource,
            SHA256Hash sha256Hash
    ) {
        this.dataSource = dataSource;
        this.sha256Hash = sha256Hash;
    }

    @Override
    public BusinessResult login(LoginUserEntity loginUserEntity) {

        if (userExists(loginUserEntity)) {
            // Hashing user password
            ((CustomerLoginEntity) loginUserEntity).setCustomerPassword(
                    sha256Hash.getSHA256Hash(
                            ((CustomerLoginEntity) loginUserEntity).getCustomerPassword()
                    )
            );
            return dataSource.login(
                    loginUserEntity
            );
        }
        else {
            return new BusinessResult(
                    DomainErrors.USER_DOES_NOT_EXIST,
                    null,
                    BusinessResultStatus.ERROR
            );
        }

    }

    @Override
    public boolean userExists(LoginUserEntity loginUserEntity) {
        return dataSource.userExists(loginUserEntity);
    }
}
