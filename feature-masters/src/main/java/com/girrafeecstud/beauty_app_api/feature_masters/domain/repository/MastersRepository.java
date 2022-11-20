package com.girrafeecstud.beauty_app_api.feature_masters.domain.repository;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;

public interface MastersRepository {

    BusinessResult getMastersList();

    BusinessResult getMasterData(String masterId);

    BusinessResult updateMasterData(String masterId, MasterEntity master);

}
