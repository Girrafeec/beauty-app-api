package com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.core_base_user_login.data.datasource.UserLoginDataSource;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.data.database.mapper.MasterLoginDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.data.datasource.MasterLoginDataSourceImpl;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.annotation.MasterLoginDao;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.di.annotation.MasterLoginDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersLoginDataSourceConfiguration {

    @Bean
    @MasterLoginDataSource
    @Scope("singleton")
    public UserLoginDataSource getMasterLoginDataSoruceImpl(
            @MasterLoginDao UserLoginDao dao,
            MasterLoginDatabaseMapper mapper
            ) {
        return new MasterLoginDataSourceImpl(
                dao,
                mapper
        );
    }

}
