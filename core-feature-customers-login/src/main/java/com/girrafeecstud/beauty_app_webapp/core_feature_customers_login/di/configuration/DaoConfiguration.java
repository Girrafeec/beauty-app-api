package com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.base_core_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.data.database.dao.CustomerLoginDaoImpl;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.di.annotation.CustomerLoginDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfiguration {

    @Bean
    @CustomerLoginDao
    @Scope("singleton")
    public UserLoginDao getCustomerRegistrationDaoImpl() {
        return new CustomerLoginDaoImpl();
    }

}
