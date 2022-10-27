package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.RegistrationUserEntity;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.mapper.MasterRegistrationDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.domain.entity.RegistationMasterEntity;

public class MasterRegistrationDataSourceImpl implements UserRegistrationDataSource {

    UserRegistrationDao dao;

    MasterRegistrationDatabaseMapper mapper;

    public MasterRegistrationDataSourceImpl(
            @MasterRegistrationDao UserRegistrationDao dao,
            MasterRegistrationDatabaseMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public void registration(RegistrationUserEntity registrationUserEntity) {
        dao.registration(
                mapper.mapFromEntity((RegistationMasterEntity) registrationUserEntity)
        );
    }

    @Override
    public boolean userExists(RegistrationUserEntity registrationUserEntity) {
        return dao.userExists(
                mapper.mapFromEntity((RegistationMasterEntity) registrationUserEntity)
        );
    }
}
