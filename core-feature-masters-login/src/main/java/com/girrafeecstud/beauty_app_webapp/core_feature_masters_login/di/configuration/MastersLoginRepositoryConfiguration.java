package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.data.repository.MasterLoginRepositoryImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.annotation.MasterLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.annotation.MasterLoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersLoginRepositoryConfiguration {

    @Bean
    @MasterLoginRepository
    @Scope("singleton")
    public UserLoginRepository getMasterLoginRepositoryImpl(
            @MasterLoginDataSource UserLoginDataSource dataSource,
            SHA256Hash sha256Hash
            ) {
        return new MasterLoginRepositoryImpl(
                dataSource,
                sha256Hash
        );
    }

}
