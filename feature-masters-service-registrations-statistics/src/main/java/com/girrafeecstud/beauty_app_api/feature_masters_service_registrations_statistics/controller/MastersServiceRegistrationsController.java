package com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.controller.mapper.MastersServiceRegistrationsDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.entity.MastersServiceRegistrationsEntity;
import com.girrafeecstud.beauty_app_api.feature_masters_service_registrations_statistics.domain.usecase.GetMastersServiceRegistrationsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/masters-service-registrations")
public class MastersServiceRegistrationsController {

    private GetMastersServiceRegistrationsUseCase getMastersServiceRegistrationsUseCase;

    private MastersServiceRegistrationsDtoEntityMapper mapper;

    public MastersServiceRegistrationsController(
            GetMastersServiceRegistrationsUseCase getMastersServiceRegistrationsUseCase,
            MastersServiceRegistrationsDtoEntityMapper mapper
    ) {
        this.getMastersServiceRegistrationsUseCase = getMastersServiceRegistrationsUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity getMastersServiceRegistrations() {
        BusinessResult result = getMastersServiceRegistrationsUseCase.getMastersServiceRegistrations();

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<MastersServiceRegistrationsEntity>) result.getData()).stream().map( mastersServiceRegistrations ->
                                mapper.mapToEntity(mastersServiceRegistrations)
                        ),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
