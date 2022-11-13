package com.girrafeecstud.beauty_app_api.feature_masters.data.database.dao;

import com.girrafeecstud.beauty_app_api.feature_masters.data.database.model.MasterDatabaseModel;

import java.sql.SQLException;
import java.util.List;

public interface MastersDao {

    List<MasterDatabaseModel> getMastersList() throws SQLException;

    MasterDatabaseModel getMasterData(String masterId) throws SQLException;

    void updateMasterData(String masterId, MasterDatabaseModel master) throws SQLException;

}
