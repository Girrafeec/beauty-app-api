package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.datasource;

import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.database.dao.UserRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.User;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.database.mapper.CustomerDatabaseMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDao;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.Customer;

public class CustomerRegistrationDataSourceImpl implements UserRegistrationDataSource {

    UserRegistrationDao dao;

    CustomerDatabaseMapper mapper;

    public CustomerRegistrationDataSourceImpl(
            @CustomerRegistrationDao UserRegistrationDao dao,
            CustomerDatabaseMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public void registration(User user) {
        dao.registration(
                mapper.mapFromEntity((Customer) user)
        );
    }

}
