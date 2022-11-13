package com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.repository.MastersRepository;
import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;

public class GetMastersListUseCase {

    private MastersRepository repository;

    public GetMastersListUseCase(MastersRepository repository) {
        this.repository = repository;
    }

    public BusinessResult getMastersList() {
        return repository.getMastersList();
    }

}
