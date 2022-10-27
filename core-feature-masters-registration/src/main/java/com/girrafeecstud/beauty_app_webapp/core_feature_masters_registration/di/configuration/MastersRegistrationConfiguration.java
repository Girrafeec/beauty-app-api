package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                MastersRegistrationUseCaseConfiguration.class,
                MastersRegistrationRepositoryConfiguration.class,
                MastersRegistrationDataSourceConfiguration.class,
                MastersRegistrationDaoConfiguration.class,
                MastersRegistrationDataLayerExtraConfiguration.class
        }
)
public class MastersRegistrationConfiguration {
}
