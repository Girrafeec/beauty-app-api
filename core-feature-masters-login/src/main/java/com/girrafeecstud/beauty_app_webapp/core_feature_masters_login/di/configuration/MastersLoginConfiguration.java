package com.girrafeecstud.beauty_app_webapp.core_feature_masters_login.di.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                MastersLoginUseCaseConfiguration.class,
                MastersLoginRepositoryConfiguration.class,
                MastersLoginDataSourceConfiguration.class,
                MastersLoginDaoConfiguration.class,
                MastersLoginDataLayerExtraConfiguration.class
        }
)
public class MastersLoginConfiguration {
}
