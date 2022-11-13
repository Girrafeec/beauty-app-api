package com.girrafeecstud.beauty_app_api.feature_masters.data.datasource;

import com.girrafeecstud.beauty_app_api.feature_masters.data.database.mapper.MasterEntityDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.feature_masters.data.database.dao.MastersDao;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class MastersDataSourceImpl implements MastersDataSource {

    private MastersDao dao;

    private MasterEntityDatabaseMapper mapper;

    public MastersDataSourceImpl(MastersDao dao, MasterEntityDatabaseMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult getMastersList() {
        try {
            return new BusinessResult(
                    dao.getMastersList().stream().map( masterDatabaseModel ->
                            mapper.mapToEntity(masterDatabaseModel)
                    ).collect(Collectors.toList()),
                    null,
                    BusinessResultStatus.SUCCESS
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
    }

    @Override
    public BusinessResult getMasterData(String masterId) {
        try {
            return new BusinessResult(
                    mapper.mapToEntity(dao.getMasterData(masterId)),
                    null,
                    BusinessResultStatus.SUCCESS
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
    }

    @Override
    public BusinessResult updateMasterData(String masterId, MasterEntity master) {
        try {
            dao.updateMasterData(masterId, mapper.mapFromEntity(master));
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.SUCCESS
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
    }
}
