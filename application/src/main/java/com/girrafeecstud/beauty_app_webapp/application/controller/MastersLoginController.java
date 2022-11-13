package com.girrafeecstud.beauty_app_webapp.application.controller;

import com.girrafeecstud.beauty_app_webapp.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.controller.mapper.MasterLoginDtoMapper;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.controller.mapper.MasterLoginJsonEntityMapper;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.domain.entity.MasterLoginEntity;
import com.girrafeecstud.beauty_app_webapp.feature_masters_login.domain.usecase.MasterLoginUseCase;
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
public class MastersLoginController {

    @Autowired
    private MasterLoginUseCase masterLoginUseCase;

    @GetMapping("/login")
    public String getMastersLoginPage() {
        return  "master_login_page";
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String body) {
        MasterLoginJsonEntityMapper mapper = new MasterLoginJsonEntityMapper();
        MasterLoginDtoMapper dtoMapper = new MasterLoginDtoMapper();
        BusinessResult result = masterLoginUseCase.login(
                mapper.mapToEntity(new JSONObject(body))
        );

        switch (result.getBusinessResultStatus()){
            case SUCCESS:
                return new ResponseEntity(
                        dtoMapper.mapFromEntity(
                                (MasterLoginEntity) result.getData()
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
