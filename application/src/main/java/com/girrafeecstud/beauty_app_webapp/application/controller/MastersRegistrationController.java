package com.girrafeecstud.beauty_app_webapp.application.controller;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.controller.mapper.MasterRegistrationJsonEntityMapper;
import com.girrafeecstud.beauty_app_webapp.feature_masters_registration.domain.usecase.MasterRegistrationUseCase;
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
@RequestMapping("/user/master")
public class MastersRegistrationController {

    @Autowired
    private MasterRegistrationUseCase masterRegistrationUseCase;

    @GetMapping("/registration")
    public String mastersRegistrationPage() {
        return  "master_registration_page";
    }

    @PostMapping(value = "/registration")
    public ResponseEntity receiveRegistrationData(@RequestBody String body) {
        // Import mapper via DI
        MasterRegistrationJsonEntityMapper mapper = new MasterRegistrationJsonEntityMapper();
        BusinessResult result = masterRegistrationUseCase.registration(
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

}
