package com.girrafeecstud.beauty_app_webapp.app.controller;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.controller.mapper.CustomerJsonEntityMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.girrafeecstud.beauty_app_webapp.core_feature_customers_registration.domain.usecase.CustomerRegistrationUseCase;

@Controller
@RequestMapping("/user/customer")
public class CustomersRegistrationController {

    @Autowired
    private CustomerRegistrationUseCase customerRegistrationUseCase;

    @GetMapping("/registration")
    public String customersRegistrationPage() {
        return  "customer_registration_page";
    }

    @PostMapping(value = "/registration")
    public ResponseEntity receiveRegistrationData(@RequestBody String body) {
        // Import mapper via DI
        CustomerJsonEntityMapper mapper = new CustomerJsonEntityMapper();
        BusinessResult result = customerRegistrationUseCase.registration(
                mapper.mapToEntity(new JSONObject(body))
        );

        switch (result.getBusinessResultStatus()){
            case SUCCESS:
                return new ResponseEntity(
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

    @GetMapping("/{id}")
    public String getCustomerPage() {
        return "customer_entry_page";
    }
}
