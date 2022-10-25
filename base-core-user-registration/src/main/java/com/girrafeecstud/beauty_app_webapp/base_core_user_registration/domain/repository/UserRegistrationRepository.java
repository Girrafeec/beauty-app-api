package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;

public interface UserRegistrationRepository {
    BusinessResult registration(User user);

    boolean userExists(User user);

}
