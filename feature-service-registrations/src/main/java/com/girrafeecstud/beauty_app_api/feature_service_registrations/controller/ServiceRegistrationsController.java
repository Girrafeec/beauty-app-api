package com.girrafeecstud.beauty_app_api.feature_service_registrations.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.controller.mapper.ServiceRegistrationDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.entity.ServiceRegistrationEntity;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.AddServiceRegistrationUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetCustomerServiceRegistrationsUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetMasterServiceRegistrationsUseCase;
import com.girrafeecstud.beauty_app_api.feature_service_registrations.domain.usecase.GetServiceRegistrationDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/service-registrations")
public class ServiceRegistrationsController {

    private AddServiceRegistrationUseCase addServiceRegistrationUseCase;
    private GetCustomerServiceRegistrationsUseCase getCustomerServiceRegistrationsUseCase;
    private GetMasterServiceRegistrationsUseCase getMasterServiceRegistrationsUseCase;
    private GetServiceRegistrationDataUseCase getServiceRegistrationDataUseCase;

    private ServiceRegistrationDtoEntityMapper mapper;

    public ServiceRegistrationsController(
            AddServiceRegistrationUseCase addServiceRegistrationUseCase,
            GetCustomerServiceRegistrationsUseCase getCustomerServiceRegistrationsUseCase,
            GetMasterServiceRegistrationsUseCase getMasterServiceRegistrationsUseCase,
            GetServiceRegistrationDataUseCase getServiceRegistrationDataUseCase,
            ServiceRegistrationDtoEntityMapper mapper
    ) {
        this.addServiceRegistrationUseCase = addServiceRegistrationUseCase;
        this.getCustomerServiceRegistrationsUseCase = getCustomerServiceRegistrationsUseCase;
        this.getMasterServiceRegistrationsUseCase = getMasterServiceRegistrationsUseCase;
        this.getServiceRegistrationDataUseCase = getServiceRegistrationDataUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity getCustomerServiceRegistrations(
            @RequestParam(value = "customer-id", required = false) String customerId
    ) {
        BusinessResult result =
                getCustomerServiceRegistrationsUseCase.getCustomerServiceRegistrations(customerId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<ServiceRegistrationEntity>) result.getData()).stream().map(serviceRegistration ->
                                mapper.mapToEntity(serviceRegistration)
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity getMasterServiceRegistrations(
            @RequestParam(value = "master-id", required = false) String masterId
    ) {
        BusinessResult result =
                getMasterServiceRegistrationsUseCase.getMasterServiceRegistrations(masterId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<ServiceRegistrationEntity>) result.getData()).stream().map(serviceRegistration ->
                                mapper.mapToEntity(serviceRegistration)
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity getServiceRegistrationData(
            @PathVariable String serviceRegistrationId
    ) {
        BusinessResult result =
                getServiceRegistrationDataUseCase.getServiceRegistrationData(serviceRegistrationId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        mapper.mapToEntity(
                                (ServiceRegistrationEntity) result.getData()
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
