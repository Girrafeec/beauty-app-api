package com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.data.repository;

import com.girrafeecstud.beauty_app_webapp.base_core.data.base.cryptography.SHA256Hash;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.data.datasource.UserRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.entity.RegistrationUserEntity;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.error.DomainErrors;
import com.girrafeecstud.beauty_app_webapp.base_core_user_registration.domain.repository.UserRegistrationRepository;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.di.annotation.CustomerRegistrationDataSource;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.entity.RegistationCustomerEntity;

public class CustomerRegistrationRepositoryImpl implements UserRegistrationRepository {

    private UserRegistrationDataSource dataSource;

    private SHA256Hash sha256Hash;

    public CustomerRegistrationRepositoryImpl(
            @CustomerRegistrationDataSource UserRegistrationDataSource dataSource,
            SHA256Hash sha256Hash
    ) {
        this.dataSource = dataSource;
        this.sha256Hash = sha256Hash;
    }

    public BusinessResult registration(RegistrationUserEntity registrationUserEntity) {
        if (userExists(registrationUserEntity)) {
            return new BusinessResult(
                    DomainErrors.USER_ALREADY_EXISTS_ERROR,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
        else {
            ((RegistationCustomerEntity) registrationUserEntity).setCustomerPassword(
                    sha256Hash.getSHA256Hash(
                            ((RegistationCustomerEntity) registrationUserEntity).getCustomerPassword()
                    )
            );
            dataSource.registration(registrationUserEntity);
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.SUCCESS
            );
        }
    }

    @Override
    public boolean userExists(RegistrationUserEntity registrationUserEntity) {
        return dataSource.userExists(registrationUserEntity);
    }

}
