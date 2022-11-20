package com.girrafeecstud.beauty_app_api.feature_masters_login.di.configuration;

import com.girrafeecstud.beauty_app_api.core_base_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_api.feature_masters_login.data.database.dao.MasterLoginDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_masters_login.di.annotation.MasterLoginDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersLoginDaoConfiguration {

    @Bean
    @MasterLoginDao
    @Scope("singleton")
    public UserLoginDao getMasterLoginDaoImpl() {
        return new MasterLoginDaoImpl();
    }

}
