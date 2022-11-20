package com.girrafeecstud.beauty_app_api.feature_services.di.configuration;

import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.AddNewServiceRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.ServiceDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.UpdateServiceRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.dao.ServicesDao;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.dao.ServicesDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_services.data.database.mapper.ServiceEntityDatabaseMapper;
import com.girrafeecstud.beauty_app_api.feature_services.data.datasource.ServicesDataSource;
import com.girrafeecstud.beauty_app_api.feature_services.data.datasource.ServicesDataSourceImpl;
import com.girrafeecstud.beauty_app_api.feature_services.data.repository.ServicesRepositoryImpl;
import com.girrafeecstud.beauty_app_api.feature_services.di.annotation.ServicesDaoImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_services.di.annotation.ServicesDataSourceImplAnnotation;
import com.girrafeecstud.beauty_app_api.feature_services.di.annotation.ServicesRepositoryImplAnotation;
import com.girrafeecstud.beauty_app_api.feature_services.domain.repository.ServicesRepository;
import com.girrafeecstud.beauty_app_api.feature_services.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServicesModuleConfiguration {

    @Bean
    @Scope("singleton")
    public AddNewServiceRequestDtoEntityMapper getAddNewServiceRequestDtoEntityMapper() {
        return new AddNewServiceRequestDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public ServiceDtoEntityMapper getServiceDtoEntityMapper() {
        return new ServiceDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public UpdateServiceRequestDtoEntityMapper getUpdateServiceRequestDtoEntityMapper() {
        return new UpdateServiceRequestDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public ServiceEntityDatabaseMapper getServiceEntityDatabaseMapper() {
        return new ServiceEntityDatabaseMapper();
    }

    @Bean
    @Scope("singleton")
    @ServicesDaoImplAnnotation
    public ServicesDao getServicesDaoImpl() {
        return new ServicesDaoImpl();
    }

    @Bean
    @Scope("singleton")
    @ServicesDataSourceImplAnnotation
    public ServicesDataSourceImpl getServicesDataSourceImpl(
            @ServicesDaoImplAnnotation ServicesDao dao,
            ServiceEntityDatabaseMapper mapper
    ) {
        return new ServicesDataSourceImpl(dao, mapper);
    }

    @Bean
    @Scope("singleton")
    @ServicesRepositoryImplAnotation
    public ServicesRepositoryImpl getServicesRepositoryImpl(
            @ServicesDataSourceImplAnnotation ServicesDataSource dataSource
            ) {
        return new ServicesRepositoryImpl(dataSource);
    }

    @Bean
    @Scope("singleton")
    public AddServiceUseCase getAddServiceUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
            ) {
        return new AddServiceUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public UpdateServiceDataUseCase getUpdateServiceDataUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
    ) {
        return new UpdateServiceDataUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetMasterServicesListUseCase getGetMasterServicesListUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
    ) {
        return new GetMasterServicesListUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetServiceDataUseCase getGetServiceDataUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
    ) {
        return new GetServiceDataUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetServicesListUseCase getGetServicesListUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
    ) {
        return new GetServicesListUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public DeleteServiceUseCase getDeleteServiceUseCase(
            @ServicesRepositoryImplAnotation ServicesRepository repository
    ) {
        return new DeleteServiceUseCase(repository);
    }

}
