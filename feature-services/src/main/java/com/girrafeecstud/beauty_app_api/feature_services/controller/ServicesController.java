package com.girrafeecstud.beauty_app_api.feature_services.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_services.controller.dto.AddNewServiceRequestDto;
import com.girrafeecstud.beauty_app_api.feature_services.controller.dto.UpdateServiceRequestDto;
import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.AddNewServiceRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.ServiceDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.controller.mapper.UpdateServiceRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_services.domain.entity.ServiceEntity;
import com.girrafeecstud.beauty_app_api.feature_services.domain.usecase.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin
public class ServicesController {

    private AddServiceUseCase addServiceUseCase;
    private DeleteServiceUseCase deleteServiceUseCase;
    private UpdateServiceDataUseCase updateServiceDataUseCase;
    private GetServicesListUseCase getServicesListUseCase;
    private GetServiceDataUseCase getServiceDataUseCase;
    private GetMasterServicesListUseCase getMasterServicesListUseCase;

    private ServiceDtoEntityMapper serviceDtoEntityMapper;
    private AddNewServiceRequestDtoEntityMapper addNewServiceRequestDtoEntityMapper;
    private UpdateServiceRequestDtoEntityMapper updateServiceRequestDtoEntityMapper;

    public ServicesController(
            AddServiceUseCase addServiceUseCase,
            DeleteServiceUseCase deleteServiceUseCase,
            UpdateServiceDataUseCase updateServiceDataUseCase,
            GetServicesListUseCase getServicesListUseCase,
            GetServiceDataUseCase getServiceDataUseCase,
            GetMasterServicesListUseCase getMasterServicesListUseCase,
            ServiceDtoEntityMapper serviceDtoEntityMapper,
            AddNewServiceRequestDtoEntityMapper addNewServiceRequestDtoEntityMapper,
            UpdateServiceRequestDtoEntityMapper updateServiceRequestDtoEntityMapper
    ) {
        this.addServiceUseCase = addServiceUseCase;
        this.deleteServiceUseCase = deleteServiceUseCase;
        this.updateServiceDataUseCase = updateServiceDataUseCase;
        this.getServicesListUseCase = getServicesListUseCase;
        this.getServiceDataUseCase = getServiceDataUseCase;
        this.getMasterServicesListUseCase = getMasterServicesListUseCase;
        this.serviceDtoEntityMapper = serviceDtoEntityMapper;
        this.addNewServiceRequestDtoEntityMapper = addNewServiceRequestDtoEntityMapper;
        this.updateServiceRequestDtoEntityMapper = updateServiceRequestDtoEntityMapper;
    }

    HttpHeaders httpHeaders = new HttpHeaders();

    @PostConstruct
    private void onControllerCreate() {
        httpHeaders.add("Access-Control-Allow-Origin", "*");
//        httpHeaders.add("Access-Control-Allow-Headers", "Content-Type");
//        httpHeaders.add("Access-Control-Allow-Methods", "GET, POST, PUT");
    }

    @GetMapping("/services")
    public ResponseEntity getServicesList() {
        BusinessResult result = getServicesListUseCase.getServicesList();

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<ServiceEntity>) result.getData()).stream().map(service ->
                                serviceDtoEntityMapper.mapFromEntity(service)
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/services/{serviceId}")
    public ResponseEntity getServiceData(
            @PathVariable String serviceId
    ) {
        BusinessResult result = getServiceDataUseCase.getServiceData(serviceId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        serviceDtoEntityMapper.mapFromEntity(
                                (ServiceEntity) result.getData()
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/masters/{masterId}/services")
    public ResponseEntity getMasterServices(
            @PathVariable String masterId
    ) {
        BusinessResult result = getMasterServicesListUseCase.getMasterServicesList(masterId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<ServiceEntity>) result.getData()).stream().map(service ->
                                serviceDtoEntityMapper.mapFromEntity(service)
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/services")
    public ResponseEntity addService(
            @RequestBody AddNewServiceRequestDto body
    ) {
        BusinessResult result = addServiceUseCase.addService(
                addNewServiceRequestDtoEntityMapper.mapFromEntity(body)
        );

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        HttpStatus.CREATED
                );
            case ERROR:
                return new ResponseEntity(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/services/{serviceId}")
    public ResponseEntity updateService(
            @PathVariable String serviceId,
            @RequestBody UpdateServiceRequestDto body
    ) {
        BusinessResult result = updateServiceDataUseCase.updateServiceData(
                updateServiceRequestDtoEntityMapper.mapToEntity(body),
                serviceId
        );

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/services/{serviceId}")
    public ResponseEntity deleteService(
            @PathVariable String serviceId
    ) {
        BusinessResult result = deleteServiceUseCase.deleteService(serviceId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
