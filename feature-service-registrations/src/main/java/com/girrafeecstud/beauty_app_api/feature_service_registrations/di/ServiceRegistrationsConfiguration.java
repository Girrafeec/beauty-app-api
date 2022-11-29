package com.girrafeecstud.beauty_app_api.feature_service_registrations.di;

import com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.mapper.ServiceRegistrationDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.dao.ServiceRegistrationsDao;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.dao.ServiceRegistrationsDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.database.mapper.ServiceRegistrationEntityDatabaseModelMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.datasource.ServiceRegistrationsDataSource;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.datasource.ServiceRegistrationsDataSourceImpl;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.data.repository.ServiceRegistrationsRepositoryImpl;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.di.annotation.ServiceRegistrationsDaoImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.di.annotation.ServiceRegistrationsDataSourceImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.di.annotation.ServiceRegistrationsRepositoryImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.repository.ServiceRegistrationsRepository;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.AddServiceRegistrationUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetServiceRegistrationDataUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetCustomerServiceRegistrationsUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetMasterServiceRegistrationsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServiceRegistrationsConfiguration {

    @Bean
    @Scope("singleton")
    public ServiceRegistrationDtoEntityMapper getServiceRegistrationDtoEntityMapper() {
        return new ServiceRegistrationDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public ServiceRegistrationEntityDatabaseModelMapper getServiceRegistrationEntityDatabaseModelMapper() {
        return new ServiceRegistrationEntityDatabaseModelMapper();
    }

    @Bean
    @Scope("singleton")
    @ServiceRegistrationsDaoImplAnnotation
    public ServiceRegistrationsDao getServiceRegistrationsDaoImpl() {
        return new ServiceRegistrationsDaoImpl();
    }

    @Bean
    @Scope("singleton")
    @ServiceRegistrationsDataSourceImplAnnotation
    public ServiceRegistrationsDataSourceImpl getServiceRegistrationsDataSourceImpl(
            @ServiceRegistrationsDaoImplAnnotation ServiceRegistrationsDao dao,
            ServiceRegistrationEntityDatabaseModelMapper mapper
    ) {
        return new ServiceRegistrationsDataSourceImpl(dao, mapper);
    }

    @Bean
    @Scope("singleton")
    @ServiceRegistrationsRepositoryImplAnnotation
    public ServiceRegistrationsRepository getServiceRegistrationsRepositoryImpl(
            @ServiceRegistrationsDataSourceImplAnnotation ServiceRegistrationsDataSource dataSource
    ) {
        return new ServiceRegistrationsRepositoryImpl(dataSource);
    }

    @Bean
    @Scope("singleton")
    public AddServiceRegistrationUseCase getAddServiceRegistrationUseCase(
            @ServiceRegistrationsRepositoryImplAnnotation ServiceRegistrationsRepository repository
    ) {
        return new AddServiceRegistrationUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetCustomerServiceRegistrationsUseCase getGetCustomerServiceRegistrationsUseCase(
            @ServiceRegistrationsRepositoryImplAnnotation ServiceRegistrationsRepository repository
    ) {
        return new GetCustomerServiceRegistrationsUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetMasterServiceRegistrationsUseCase getGetMasterServiceRegistrationsUseCase(
            @ServiceRegistrationsRepositoryImplAnnotation ServiceRegistrationsRepository repository
    ) {
        return new GetMasterServiceRegistrationsUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetServiceRegistrationDataUseCase getGerServiceRegistrationDataUseCase(
            @ServiceRegistrationsRepositoryImplAnnotation ServiceRegistrationsRepository repository
    ) {
        return new GetServiceRegistrationDataUseCase(repository);
    }

}
