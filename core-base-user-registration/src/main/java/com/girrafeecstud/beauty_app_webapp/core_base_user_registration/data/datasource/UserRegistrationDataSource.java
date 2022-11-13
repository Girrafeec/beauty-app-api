package com.girrafeecstud.beauty_app_webapp.core_base_user_registration.data.datasource;

import com.girrafeecstud.beauty_app_webapp.core_base_user_registration.domain.entity.RegistrationUserEntity;

public interface UserRegistrationDataSource {
    void registration(RegistrationUserEntity registrationUserEntity);

    boolean userExists(RegistrationUserEntity registrationUserEntity);
}
