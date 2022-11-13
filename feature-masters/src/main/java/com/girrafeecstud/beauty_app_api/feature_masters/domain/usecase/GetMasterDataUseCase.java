package com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.repository.MastersRepository;
import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;

public class GetMasterDataUseCase {

    private MastersRepository repository;

    public GetMasterDataUseCase(MastersRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getMasterData(String masterId) {
        return repository.getMasterData(masterId);
    }
}
