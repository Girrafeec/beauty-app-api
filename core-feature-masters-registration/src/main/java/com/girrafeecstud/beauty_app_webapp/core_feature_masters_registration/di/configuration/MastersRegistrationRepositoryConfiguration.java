package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.configuration;
import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.repository.MasterRegistrationRepositoryImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersRegistrationRepositoryConfiguration {

    @Bean
    @MasterRegistrationRepository
    @Scope("singleton")
    public UserRegistrationRepository getMasterRegistrationRepositoryImpl(
            @MasterRegistrationDataSource UserRegistrationDataSource dataSource,
            SHA256Hash sha256Hash
            ) {
        return new MasterRegistrationRepositoryImpl(
                dataSource,
                sha256Hash
        );
    }

}
