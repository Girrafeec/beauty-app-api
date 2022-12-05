package com.girrafeecstud.beauty_app_api.feature_customers.data.datasource;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResultStatus;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.dao.CustomersDao;
import com.girrafeecstud.beauty_app_api.feature_customers.data.database.mapper.CustomerDatabaseEntityMapper;

import java.sql.SQLException;

public class CustomersDataSourceImpl implements CustomersDataSource {

    private CustomersDao dao;

    private CustomerDatabaseEntityMapper mapper;

    public CustomersDataSourceImpl(
            CustomersDao dao,
            CustomerDatabaseEntityMapper mapper
    ) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public BusinessResult getCustomerData(String customerId) {
        try {
            return new BusinessResult(
                    mapper.mapToEntity(dao.getCustomerData(customerId)),
                    null,
                    BusinessResultStatus.SUCCESS
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return new BusinessResult(
                    null,
                    null,
                    BusinessResultStatus.ERROR
            );
        }
    }
}
