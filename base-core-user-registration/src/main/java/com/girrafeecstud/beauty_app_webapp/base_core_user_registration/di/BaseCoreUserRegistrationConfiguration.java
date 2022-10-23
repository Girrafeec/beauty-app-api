package com.girrafeecstud.beauty_app_webapp.base_core_user_registration.di;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BaseCoreUserRegistrationConfiguration {

    @Bean
    @Scope("singleton")
    public SHA256Hash getSHA256Hash() {
        return new SHA256Hash();
    }

}
