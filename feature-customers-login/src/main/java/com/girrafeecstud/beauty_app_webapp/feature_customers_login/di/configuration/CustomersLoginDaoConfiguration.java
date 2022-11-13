package com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.configuration;

import com.girrafeecstud.beauty_app_webapp.core_base_user_login.data.database.dao.UserLoginDao;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.data.database.dao.CustomerLoginDaoImpl;
import com.girrafeecstud.beauty_app_webapp.feature_customers_login.di.annotation.CustomerLoginDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersLoginDaoConfiguration {

    @Bean
    @CustomerLoginDao
    @Scope("singleton")
    public UserLoginDao getCustomerLoginDaoImpl() {
        return new CustomerLoginDaoImpl();
    }

}
