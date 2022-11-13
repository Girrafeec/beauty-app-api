package com.girrafeecstud.beauty_app_webapp.feature_masters_registration.controller;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.controller.mapper.MasterRegistrationJsonEntityMapper;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.domain.usecase.MasterRegistrationUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration/masters")
public class MastersRegistrationController {

    @Autowired
    private MasterRegistrationUseCase masterRegistrationUseCase;

    @PostMapping
    public ResponseEntity receiveRegistrationData(@RequestBody String body) {
        // Import mapper via DI
        MasterRegistrationJsonEntityMapper mapper = new MasterRegistrationJsonEntityMapper();
        BusinessResult result = masterRegistrationUseCase.registration(
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
