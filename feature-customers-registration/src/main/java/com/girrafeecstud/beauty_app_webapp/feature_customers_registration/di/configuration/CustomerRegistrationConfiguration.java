package com.girrafeecstud.beauty_app_webapp.feature_customers_registration.di.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                CustomersRegistrationUseCaseConfiguration.class,
                CustomersRegistrationRepositoryConfiguration.class,
                CustomersRegistrationDataSourceConfiguration.class,
                CustomersRegistrationDaoConfiguration.class,
                CustomersRegistrationDataLayerExtraConfiguration.class
        }
)
public class CustomerRegistrationConfiguration {
}
