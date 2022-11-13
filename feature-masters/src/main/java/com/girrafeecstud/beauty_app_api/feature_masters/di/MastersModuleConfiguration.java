package com.girrafeecstud.beauty_app_api.feature_masters.di;

import com.girrafeecstud.beauty_app_api.feature_masters.data.database.dao.MastersDao;
import com.girrafeecstud.beauty_app_api.feature_masters.data.database.dao.MastersDaoImpl;
import com.girrafeecstud.beauty_app_api.feature_masters.data.database.mapper.MasterEntityDatabaseMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.data.datasource.MastersDataSource;
import com.girrafeecstud.beauty_app_api.feature_masters.data.datasource.MastersDataSourceImpl;
import com.girrafeecstud.beauty_app_api.feature_masters.data.repository.MastersRepositoryImpl;
import com.girrafeecstud.beauty_app_api.feature_masters.di.annotation.MastersDaoAnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters.di.annotation.MastersDataSourceAnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters.di.annotation.MastersRepositoryAnnotation;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.repository.MastersRepository;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.GetMastersListUseCase;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper.MasterEntityResponseDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper.UpdateMasterRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.GetMasterDataUseCase;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.UpdateMasterDataUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MastersModuleConfiguration {

    @Bean
    @Scope("singleton")
    @MastersDaoAnnotation
    public MastersDao getMastersDaoImpl() {
        return new MastersDaoImpl();
    }

    @Bean
    @Scope("singleton")
    public MasterEntityDatabaseMapper getMasterEntityDatabaseMapper() {
        return new MasterEntityDatabaseMapper();
    }

    @Bean
    @Scope("singleton")
    public UpdateMasterRequestDtoEntityMapper getUpdateMasterRequestDtoEntityMapper() {
        return new UpdateMasterRequestDtoEntityMapper();
    }

    @Bean
    @Scope("singleton")
    public MasterEntityResponseDtoMapper getMasterEntityRequestDtoMapper() {
        return new MasterEntityResponseDtoMapper();
    }

    @Bean
    @Scope("singleton")
    @MastersDataSourceAnnotation
    public MastersDataSource getMastersDataSourceImpl(
            @MastersDaoAnnotation MastersDao dao,
            MasterEntityDatabaseMapper masterEntityDatabaseMapper
    ) {
        return new MastersDataSourceImpl(dao, masterEntityDatabaseMapper);
    }

    @Bean
    @Scope("singleton")
    @MastersRepositoryAnnotation
    public MastersRepository getMastersRepositoryImpl(
            @MastersDataSourceAnnotation MastersDataSource dataSource
    ) {
        return new MastersRepositoryImpl(dataSource);
    }

    @Bean
    @Scope("singleton")
    public GetMastersListUseCase getGetMastersListUseCase(
            @MastersRepositoryAnnotation MastersRepository repository
            ) {
        return new GetMastersListUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public GetMasterDataUseCase getGetMasterDataUseCase(
            @MastersRepositoryAnnotation MastersRepository repository
    ) {
        return new GetMasterDataUseCase(repository);
    }

    @Bean
    @Scope("singleton")
    public UpdateMasterDataUseCase getUpdateMasterDataUseCase(
            @MastersRepositoryAnnotation MastersRepository repository
    ) {
        return new UpdateMasterDataUseCase(repository);
    }

}
