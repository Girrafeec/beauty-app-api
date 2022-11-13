package com.girrafeecstud.beauty_app_api.feature_masters.data.datasource;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;

public interface MastersDataSource {

    BusinessResult getMastersList();

    BusinessResult getMasterData(String masterId);

    BusinessResult updateMasterData(String masterId, MasterEntity master);

}
