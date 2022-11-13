package com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                CustomersLoginUseCaseConfiguration.class,
                CustomersLoginRepositoryConfiguration.class,
                CustomersLoginDataSourceConfiguration.class,
                CustomersLoginDaoConfiguration.class,
                CustomersLoginDataLayerExtraConfiguration.class
        }
)
public class CustomersLoginConfiguration {
}
