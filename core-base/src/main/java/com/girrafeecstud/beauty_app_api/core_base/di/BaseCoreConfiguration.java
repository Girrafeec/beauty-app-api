package com.girrafeecstud.beauty_app_api.core_base.di;

import com.girrafeecstud.beauty_app_api.core_base.data.base.cryptography.SHA256Hash;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BaseCoreConfiguration {

    @Bean
    @Scope("singleton")
    public SHA256Hash getSHA256Hash() {
        return new SHA256Hash();
    }

}
