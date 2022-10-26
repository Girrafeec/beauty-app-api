package data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.RegistrationUserEntity;

public interface UserRegistrationDataSource {
    void registration(RegistrationUserEntity registrationUserEntity);

    boolean userExists(RegistrationUserEntity registrationUserEntity);
}
