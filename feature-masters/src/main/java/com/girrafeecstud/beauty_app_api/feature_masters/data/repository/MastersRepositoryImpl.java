package com.girrafeecstud.beauty_app_api.feature_masters.data.repository;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters.data.datasource.MastersDataSource;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.repository.MastersRepository;

public class MastersRepositoryImpl implements MastersRepository {

    private MastersDataSource dataSource;

    public MastersRepositoryImpl(MastersDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BusinessResult getMastersList() {
        return dataSource.getMastersList();
    }

    @Override
    public BusinessResult getMasterData(String masterId) {
        return dataSource.getMasterData(masterId);
    }

    @Override
    public BusinessResult updateMasterData(String masterId, MasterEntity master) {
        return dataSource.updateMasterData(masterId, master);
    }
}
