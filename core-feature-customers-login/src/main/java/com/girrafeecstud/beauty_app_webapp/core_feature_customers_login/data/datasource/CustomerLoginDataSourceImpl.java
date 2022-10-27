package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.error.DomainErrors;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.database.mapper.CustomerLoginDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.database.model.CustomerLoginDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.annotation.CustomerLoginDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.entity.CustomerLoginEntity;

public class CustomerLoginDataSourceImpl implements UserLoginDataSource {

    private UserLoginDao dao;

    private CustomerLoginDatabaseMapper mapper;

    public CustomerLoginDataSourceImpl(
            @CustomerLoginDao UserLoginDao dao,
            CustomerLoginDatabaseMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult login(LoginUserEntity loginUserEntity) {

        if (
                dao.passwordMatches(
                        mapper.mapFromEntity((CustomerLoginEntity) loginUserEntity)
                )
        ) {
            return new BusinessResult<>(
                    mapper.mapToEntity(
                            (CustomerLoginDatabaseModel) dao.getUserId(
                                    mapper.mapFromEntity((CustomerLoginEntity) loginUserEntity)
                            )
                    ),
                    null,
                    BusinessResultStatus.SUCCESS
            );
        }

        return new BusinessResult(
                DomainErrors.INVALID_PASSWORD,
                null,
                BusinessResultStatus.ERROR
        );
    }

    @Override
    public boolean userExists(LoginUserEntity loginUserEntity) {
        return dao.userExists(
                mapper.mapFromEntity((CustomerLoginEntity) loginUserEntity)
        );
    }
}
