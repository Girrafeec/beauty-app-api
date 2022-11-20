package com.girrafeecstud.beauty_app_api.feature_customers_login.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_customers_login.controller.mapper.CustomerLoginDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_login.controller.mapper.CustomerLoginJsonEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_login.domain.entity.CustomerLoginEntity;
import com.girrafeecstud.beauty_app_api.feature_customers_login.domain.usecase.CustomerLoginUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/customers")
public class CustomersLoginController {

    @Autowired
    private CustomerLoginUseCase customerLoginUseCase;

    @PostMapping
    public ResponseEntity login(@RequestBody String body) {
        CustomerLoginJsonEntityMapper mapper = new CustomerLoginJsonEntityMapper();
        CustomerLoginDtoMapper dtoMapper = new CustomerLoginDtoMapper();
        BusinessResult result = customerLoginUseCase.login(
                mapper.mapToEntity(new JSONObject(body))
        );

        switch (result.getBusinessResultStatus()){
            case SUCCESS:
                return new ResponseEntity(
                        dtoMapper.mapFromEntity(
                                (CustomerLoginEntity) result.getData()
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(
                        HttpStatus.BAD_REQUEST
                );
        }
        return new ResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
