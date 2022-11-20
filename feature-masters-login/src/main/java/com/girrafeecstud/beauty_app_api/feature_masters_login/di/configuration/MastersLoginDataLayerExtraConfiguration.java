package com.girrafeecstud.beauty_app_api.feature_masters_login.di.configuration;

import com.girrafeecstud.beauty_app_api.feature_masters_login.data.database.mapper.MasterLoginDatabaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersLoginDataLayerExtraConfiguration {

    @Bean
    @Scope("singleton")
    public MasterLoginDatabaseMapper getLoginMasterDatabaseMapper() {
        return new MasterLoginDatabaseMapper();
    }

}
