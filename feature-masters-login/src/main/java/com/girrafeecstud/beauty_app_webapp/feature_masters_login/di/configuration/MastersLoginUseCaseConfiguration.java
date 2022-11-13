package com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_login.domain.repository.UserLoginRepository;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.annotation.MasterLoginRepository;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.domain.usecase.MasterLoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersLoginUseCaseConfiguration {
    @Bean
    @Scope("singleton")
    public MasterLoginUseCase getMasterLoginUseCase(
            @MasterLoginRepository UserLoginRepository repository
    ) {
        return new MasterLoginUseCase(repository);
    }
}
