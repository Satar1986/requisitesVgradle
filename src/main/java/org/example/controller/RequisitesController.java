package org.example.controller;




import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;

import org.example.dto.ApiDto;
import org.example.service.MappingApi;
import org.openapi.example.model.Requisites;

import org.openapi.example.api.RequisitesApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
 class RequisitesController implements RequisitesApi {
 private final MappingApi mappingApi;

     @Override
public ResponseEntity<List<Requisites>> getRequisites() {
         List<ApiDto> apiDtos=mappingApi.getRequisitesApiIds();
         List<Requisites> requisitesList=apiDtos.parallelStream().map(apiDto -> getRequisites(apiDto)).collect(Collectors.toList());
         return new  ResponseEntity<>(requisitesList ,HttpStatus.OK);}

      @Override
public ResponseEntity<Requisites> getRequisitesById(@Parameter(name = "externalId", description = "Requisites",
        required = true, in = ParameterIn.PATH)
                                                    @PathVariable("externalId") String externalId) {
    ApiDto apiDto=mappingApi.getRequisitesApiId(externalId);
    Requisites requisites= getRequisites(apiDto);
    return  new ResponseEntity<>(requisites, HttpStatus.OK);}

    public Requisites getRequisites(ApiDto apiDto){
        Requisites requisites=new Requisites();
        requisites.setExternalId(apiDto.getExternalId());
        requisites.setId(apiDto.getId());
        requisites.setOgrn(apiDto.getOgrn());
        requisites.setKpp(apiDto.getKpp());
        requisites.setRcbic(apiDto.getRcbic());
        requisites.setInn(apiDto.getInn());
        requisites.setAss(apiDto.getAss());
        requisites.setNameCompany(apiDto.getName_company());
        requisites.setCorrAss(apiDto.getCorr_ass());
        requisites.setClientId(apiDto.getClient_id());
        requisites.setBankName(apiDto.getBank_name());
        requisites.setAddress(apiDto.getAddress());
        requisites.businessAddress(apiDto.getBusiness_address());
        requisites.setCreated(apiDto.getCreated());
        requisites.setUpdated(apiDto.getUpdated());
        return requisites;
    }
}
