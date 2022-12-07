package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.di;

import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller.mapper.MastersServiceRegistrationsDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.dao.MastersServiceRegistrationsDao;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.dao.MastersServiceRegistrationsDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.database.mapper.MastersServiceRegistrationsDatabaseEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.datasource.MastersServiceRegistrationsDataSource;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.datasource.MastersServiceRegistrationsDataSourceImpl;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.data.repository.MastersServiceRegistrationsRepositoryImpl;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.di.annotation.MastersServiceRegistrationsDaoImplAnnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.di.annotation.MastersServiceRegistrationsDataSourceImplAnnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.di.annotation.MastersServiceRegistrationsRepositoryImplAnnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.repository.MastersServiceRegistrationsRepository;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.usecase.GetMastersServiceRegistrationsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersServiceRegistrationsStatisticsModuleConfiguration {

    @Bean
    @Scope("singleton")
    public MastersServiceRegistrationsDtoEntityMapper getMastersServiceRegistrationsDtoEntityMapper() {
        return new MastersServiceRegistrationsDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public MastersServiceRegistrationsDatabaseEntityMapper getMastersServiceRegistrationsDatabaseEntityMapper() {
        return new MastersServiceRegistrationsDatabaseEntityMapper();
    }

    @Bean
    @Scope("singleton")
    @MastersServiceRegistrationsDaoImplAnnnotation
    public MastersServiceRegistrationsDao getMastersServiceRegistrationsDaoImpl() {
        return new MastersServiceRegistrationsDaoImpl();
    }

    @Bean
    @Scope("singleton")
    @MastersServiceRegistrationsDataSourceImplAnnnotation
    public MastersServiceRegistrationsDataSource getMastersServiceRegistrationsDataSourceImpl(
            @MastersServiceRegistrationsDaoImplAnnnotation MastersServiceRegistrationsDao dao,
            MastersServiceRegistrationsDatabaseEntityMapper mapper
    ) {
        return new MastersServiceRegistrationsDataSourceImpl(dao, mapper);
    }

    @Bean
    @Scope("singleton")
    @MastersServiceRegistrationsRepositoryImplAnnnotation
    public MastersServiceRegistrationsRepository getMastersServiceRegistrationsRepositoryImpl(
            @MastersServiceRegistrationsDataSourceImplAnnnotation MastersServiceRegistrationsDataSource dataSource
    ) {
        return new MastersServiceRegistrationsRepositoryImpl(dataSource);
    }

    @Bean
    @Scope("singleton")
    public GetMastersServiceRegistrationsUseCase getGetMastersServiceRegistrationsUseCase(
            @MastersServiceRegistrationsRepositoryImplAnnnotation MastersServiceRegistrationsRepository repository
            ) {
        return new GetMastersServiceRegistrationsUseCase(repository);
    }

}
