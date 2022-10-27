package com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.data.database.dao.MasterRegistrationDaoImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_masters_registration.di.annotation.MasterRegistrationDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersRegistrationDaoConfiguration {

    @Bean
    @MasterRegistrationDao
    @Scope("singleton")
    public UserRegistrationDao getMasterRegistrationDaoImpl() {
        return new MasterRegistrationDaoImpl();
    }

}
