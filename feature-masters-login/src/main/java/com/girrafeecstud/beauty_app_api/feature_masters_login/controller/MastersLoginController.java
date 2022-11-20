package com.girrafeecstud.beauty_app_api.feature_masters_login.controller;

import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters_login.controller.mapper.MasterLoginDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_login.controller.mapper.MasterLoginJsonEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters_login.domain.entity.MasterLoginEntity;
import com.girrafeecstud.beauty_app_api.feature_masters_login.domain.usecase.MasterLoginUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/masters")
public class MastersLoginController {

    @Autowired
    private MasterLoginUseCase masterLoginUseCase;

    @PostMapping
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
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
