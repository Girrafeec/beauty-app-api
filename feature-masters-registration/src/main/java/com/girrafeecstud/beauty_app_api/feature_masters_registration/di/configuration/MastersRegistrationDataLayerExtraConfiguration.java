package com.girrafeecstud.beauty_app_api.feature_masters_registration.di.configuration;

import com.girrafeecstud.beauty_app_api.feature_masters_registration.data.database.mapper.MasterRegistrationDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersRegistrationDataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public MasterRegistrationDatabaseMapper getMasterDatabaseMapper() {
        return new MasterRegistrationDatabaseMapper();
    }

}
