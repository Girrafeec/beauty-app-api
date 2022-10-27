package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.error.DomainErrors;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.entity.LoginUserEntity;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.mapper.MasterLoginDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.database.model.MasterLoginDatabaseModel;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.annotation.MasterLoginDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.domain.entity.MasterLoginEntity;

public class MasterLoginDataSourceImpl implements UserLoginDataSource {

    private UserLoginDao dao;

    private MasterLoginDatabaseMapper mapper;

    public MasterLoginDataSourceImpl(
            @MasterLoginDao UserLoginDao dao,
            MasterLoginDatabaseMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult login(LoginUserEntity loginUserEntity) {

        if (
                dao.passwordMatches(
                        mapper.mapFromEntity((MasterLoginEntity) loginUserEntity)
                )
        ) {
            return new BusinessResult<>(
                    mapper.mapToEntity(
                            (MasterLoginDatabaseModel) dao.getUserId(
                                    mapper.mapFromEntity((MasterLoginEntity) loginUserEntity)
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
                mapper.mapFromEntity((MasterLoginEntity) loginUserEntity)
        );
    }
}
