package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                UseCaseConfiguration.class,
                RepositoryConfiguration.class,
                DataSourceConfiguration.class,
                DaoConfiguration.class,
                DataLayerExtraConfiguration.class
        }
)
public class CustomerRegistrationConfiguration {
}
