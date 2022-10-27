package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.mapper.MasterRegistrationDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.datasource.MasterRegistrationDataSourceImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersRegistrationDataSourceConfiguration {

    @Bean
    @MasterRegistrationDataSource
    @Scope("singleton")
    public UserRegistrationDataSource getMasterRegistrationDataSoruceImpl(
            @MasterRegistrationDao UserRegistrationDao dao,
            MasterRegistrationDatabaseMapper mapper
            ) {
        return new MasterRegistrationDataSourceImpl(
                dao,
                mapper
        );
    }

}
