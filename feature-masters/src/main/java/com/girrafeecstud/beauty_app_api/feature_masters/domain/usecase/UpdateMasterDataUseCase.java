package com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.repository.MastersRepository;
import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;

public class UpdateMasterDataUseCase {

    private MastersRepository repository;

    public UpdateMasterDataUseCase(MastersRepository repository) {
        this.repository = repository;
    }

    public BusinessResult updateMasterData(String masterId, MasterEntity master) {
        return repository.updateMasterData(masterId, master);
    }

}
