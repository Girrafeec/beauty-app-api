package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;

public interface UserRegistrationRepository {
    void registration(User user);
}
