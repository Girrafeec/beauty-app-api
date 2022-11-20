package com.girrafeecstud.beauty_app_api.core_base_user_registration.domain.repository;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base_user_registration.domain.entity.RegistrationUserEntity;

public interface UserRegistrationRepository {
    BusinessResult registration(RegistrationUserEntity registrationUserEntity);

    boolean userExists(RegistrationUserEntity registrationUserEntity);

}
