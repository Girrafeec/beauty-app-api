package com.girrafeecstud.beauty_app_webapp.feature_masters_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.di.annotation.MasterRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.domain.usecase.MasterRegistrationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersRegistrationUseCaseConfiguration {
    @Bean
    @Scope("singleton")
    public MasterRegistrationUseCase getMasterRegistrationUseCase(
            @MasterRegistrationRepository UserRegistrationRepository repository
    ) {
        return new MasterRegistrationUseCase(repository);
    }
}
