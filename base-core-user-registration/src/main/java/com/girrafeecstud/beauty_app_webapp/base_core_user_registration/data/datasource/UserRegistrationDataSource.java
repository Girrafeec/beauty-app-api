package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;

public interface UserRegistrationDataSource {
    void registration(User user);
}
