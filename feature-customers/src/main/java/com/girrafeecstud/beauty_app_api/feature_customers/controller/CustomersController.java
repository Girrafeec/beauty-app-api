package com.girrafeecstud.beauty_app_api.feature_customers.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_customers.controller.mapper.CustomerEntityDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.entity.CustomerEntity;
import com.girrafeecstud.beauty_app_api.feature_customers.domain.usecase.GetCustomerDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomersController {

    private GetCustomerDataUseCase getCustomerDataUseCase;

    private CustomerEntityDtoMapper mapper;

    public CustomersController(
            GetCustomerDataUseCase getCustomerDataUseCase,
            CustomerEntityDtoMapper mapper
    ) {
        this.getCustomerDataUseCase = getCustomerDataUseCase;
        this.mapper = mapper;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity getCustomerData(
        @PathVariable String customerId
    ) {
        BusinessResult result = getCustomerDataUseCase.getCustomerData(customerId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        mapper.mapFromEntity(
                                (CustomerEntity) result.getData()
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
