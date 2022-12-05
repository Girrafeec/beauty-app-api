package com.girrafeecstud.beauty_app_api.feature_customers.di;

import com.girrafeecstud.beauty_app_api.feature_customers.controller.mapper.CustomerEntityDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.dao.CustomersDao;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.dao.CustomersDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.mapper.CustomerDatabaseEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers.data.datasource.CustomersDataSource;
import com.girrafeecstud.beauty_app_api.feature_customers.data.datasource.CustomersDataSourceImpl;
import com.girrafeecstud.beauty_app_api.feature_customers.data.repository.CustomersRepositoryImpl;
import com.girrafeecstud.beauty_app_api.feature_customers.di.annotation.CustomersDaoImpAnnotation;
import com.girrafeecstud.beauty_app_api.feature_customers.di.annotation.CustomersDataSourceImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_customers.di.annotation.CustomersRepositoryImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.repository.CustomersRepository;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.usecase.GetCustomerDataUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomersModuleConfiguration {

    @Bean
    @Scope("singleton")
    public CustomerDatabaseEntityMapper getCustomerDatabaseEntityMapper() {
        return new CustomerDatabaseEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public CustomerEntityDtoMapper getCustomerEntityDtoMapper() {
        return new CustomerEntityDtoMapper();
    }

    @Bean
    @Scope("singleton")
    @CustomersDaoImpAnnotation
    public CustomersDao getCustomersDaoImpl() {
        return new CustomersDaoImpl();
    }

    @Bean
    @Scope("singleton")
    @CustomersDataSourceImplAnnotation
    public CustomersDataSource getCustomersDataSourceImpl(
            @CustomersDaoImpAnnotation CustomersDao dao,
            CustomerDatabaseEntityMapper mapper
    ) {
        return new CustomersDataSourceImpl(dao, mapper);
    }

    @Bean
    @Scope("singleton")
    @CustomersRepositoryImplAnnotation
    public CustomersRepository getCustomersRepositoryImpl(
            @CustomersDataSourceImplAnnotation CustomersDataSource dataSource
    ) {
        return new CustomersRepositoryImpl(dataSource);
    }

    @Bean
    @Scope("singleton")
    public GetCustomerDataUseCase getGetCustomerDataUseCase(
            @CustomersRepositoryImplAnnotation CustomersRepository repository
            ) {
        return new GetCustomerDataUseCase(repository);
    }

}
