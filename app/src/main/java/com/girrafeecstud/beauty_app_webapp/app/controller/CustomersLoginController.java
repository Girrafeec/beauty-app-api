package com.girrafeecstud.beauty_app_webapp.app.controller;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.controller.mapper.CustomerLoginDtoMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.controller.mapper.CustomerLoginJsonEntityMapper;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.entity.CustomerLoginEntity;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_login.domain.usecase.CustomerLoginUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/customer")
public class CustomersLoginController {

    @Autowired
    private CustomerLoginUseCase customerLoginUseCase;

    @GetMapping("/login")
    public String getCustomersLoginPage() {
        System.out.println("login controller request");
        return  "customer_login_page";
    }

    @PostMapping("/login")
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
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }

}
