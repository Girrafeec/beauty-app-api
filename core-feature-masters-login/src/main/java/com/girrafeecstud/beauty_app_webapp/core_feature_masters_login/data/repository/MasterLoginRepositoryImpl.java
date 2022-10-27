package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.repository;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.error.DomainErrors;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.annotation.MasterLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity.MasterLoginEntity;

public class MasterLoginRepositoryImpl implements UserLoginRepository {

    private UserLoginDataSource dataSource;

    private SHA256Hash sha256Hash;

    public MasterLoginRepositoryImpl(
            @MasterLoginDataSource UserLoginDataSource dataSource,
            SHA256Hash sha256Hash
    ) {
        this.dataSource = dataSource;
        this.sha256Hash = sha256Hash;
    }

    @Override
    public BusinessResult login(LoginUserEntity loginUserEntity) {

        if (userExists(loginUserEntity)) {
            // Hashing user password
            ((MasterLoginEntity) loginUserEntity).setMasterPassword(
                    sha256Hash.getSHA256Hash(
                            ((MasterLoginEntity) loginUserEntity).getMasterPassword()
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
