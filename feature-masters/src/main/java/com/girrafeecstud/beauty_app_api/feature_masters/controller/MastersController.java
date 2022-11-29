package com.girrafeecstud.beauty_app_api.feature_masters.controller;

import com.girrafeecstud.beauty_app_api.feature_masters.domain.entity.MasterEntity;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.GetMastersListUseCase;
import com.girrafeecstud.beauty_app_api.core_base.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.dto.UpdateMasterDataRequestDto;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper.MasterEntityResponseDtoMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.controller.mapper.UpdateMasterRequestDtoEntityMapper;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.GetMasterDataUseCase;
import com.girrafeecstud.beauty_app_api.feature_masters.domain.usecase.UpdateMasterDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class MastersController {

    private GetMastersListUseCase getMastersListUseCase;
    private GetMasterDataUseCase getMasterDataUseCase;
    private UpdateMasterDataUseCase updateMasterDataUseCase;

    private MasterEntityResponseDtoMapper masterEntityResponseDtoMapper;
    private UpdateMasterRequestDtoEntityMapper updateMasterRequestDtoEntityMapper;

    public MastersController(
            GetMastersListUseCase getMastersListUseCase,
            GetMasterDataUseCase getMasterDataUseCase,
            UpdateMasterDataUseCase updateMasterDataUseCase,
            MasterEntityResponseDtoMapper masterEntityResponseDtoMapper,
            UpdateMasterRequestDtoEntityMapper updateMasterRequestDtoEntityMapper
    ) {
        this.getMastersListUseCase = getMastersListUseCase;
        this.getMasterDataUseCase = getMasterDataUseCase;
        this.updateMasterDataUseCase = updateMasterDataUseCase;
        this.masterEntityResponseDtoMapper = masterEntityResponseDtoMapper;
        this.updateMasterRequestDtoEntityMapper = updateMasterRequestDtoEntityMapper;
    }

    @GetMapping("/masters")
    public ResponseEntity getMasters() {
        BusinessResult result = getMastersListUseCase.getMastersList();

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        ((List<MasterEntity>) result.getData()).stream().map(master ->
                                masterEntityResponseDtoMapper.mapFromEntity(master)
                        ),
                        HttpStatus.OK

                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/masters/{masterId}")
    public ResponseEntity getMsterInfo(
            @PathVariable String masterId
    ) {
        BusinessResult result = getMasterDataUseCase.getMasterData(masterId);

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(
                        masterEntityResponseDtoMapper.mapFromEntity((MasterEntity) result.getData()),
                        HttpStatus.OK
                );
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/masters/{masterId}")
    public ResponseEntity updateMasterInfo(
            @PathVariable String masterId,
            @RequestBody UpdateMasterDataRequestDto body
    ) {
        BusinessResult result = updateMasterDataUseCase.updateMasterData(
                masterId,
                updateMasterRequestDtoEntityMapper.mapFromEntity(body)
        );

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                return new ResponseEntity(HttpStatus.OK);
            case ERROR:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
