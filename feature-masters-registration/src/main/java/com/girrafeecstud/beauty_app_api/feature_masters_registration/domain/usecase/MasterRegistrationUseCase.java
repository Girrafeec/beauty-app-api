package com.girrafeecstud.beauty_app_api.feature_masters_registration.domain.usecase;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.di.annotation.MasterRegistrationRepository;
import com.girrafeecstud.beauty_app_api.feature_masters_registration.domain.entity.RegistationMasterEntity;

public class MasterRegistrationUseCase {

    private UserRegistrationRepository repository;

    public MasterRegistrationUseCase(
            @MasterRegistrationRepository UserRegistrationRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessResult registration(RegistationMasterEntity master) {
        return repository.registration(master);
    }

}
