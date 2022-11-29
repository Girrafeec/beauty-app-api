package com.girrafeecstud.beauty_app_api.feature_customers_registration.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.controller.mapper.CustomerRegistrationJsonEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_customers_registration.domain.usecase.CustomerRegistrationUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/registration/customers")
public class CustomersRegistrationController {

    @Autowired
    private CustomerRegistrationUseCase customerRegistrationUseCase;

    @PostMapping
    public ResponseEntity receiveRegistrationData(@RequestBody String body) {
        // Import mapper via DI
        CustomerRegistrationJsonEntityMapper mapper = new CustomerRegistrationJsonEntityMapper();
        BusinessResult result = customerRegistrationUseCase.registration(
                mapper.mapToEntity(new JSONObject(body))
        );

        switch (result.getBusinessResultStatus()){
            case SUCCESS:
                return new ResponseEntity(
                        HttpStatus.CREATED
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
