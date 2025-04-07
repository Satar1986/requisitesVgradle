package org.example.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.example.service.RequisitesTransaction;
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
 private final RequisitesTransaction requisitesTransaction;

     @Override
public ResponseEntity<List<Requisites>> getRequisites() {
         List<org.example.model.Requisites> list=requisitesTransaction.readAll();
         List<Requisites> requisitesList=list.stream().map(this::getRequisites).
                 collect(Collectors.toList());
         return new  ResponseEntity<>(requisitesList ,HttpStatus.OK);
     }

     @Override
public ResponseEntity<Requisites> getRequisitesById(@Parameter(name = "externalId",
              description = "Requisites",
        required = true, in = ParameterIn.PATH)
                                                    @PathVariable("externalId") String externalId) {
         org.example.model.Requisites requisitesEntity =requisitesTransaction.readById(externalId);
    Requisites requisites= getRequisites(requisitesEntity);
    return  new ResponseEntity<>(requisites, HttpStatus.OK);
     }

     public Requisites getRequisites(org.example.model.Requisites requisitesEntity) {
        Requisites requisites=new Requisites();
        requisites.setExternalId(requisitesEntity.getExternalId());
        requisites.setId(requisitesEntity.getId());
        requisites.setOgrn(requisitesEntity.getOgrn());
        requisites.setKpp(requisitesEntity.getKpp());
        requisites.setRcbic(requisitesEntity.getRcbic());
        requisites.setInn(requisitesEntity.getInn());
        requisites.setAss(requisitesEntity.getAss());
        requisites.setNameCompany(requisitesEntity.getNameCompany());
        requisites.setCorrAss(requisitesEntity.getCorrAss());
        requisites.setClientId(requisitesEntity.getClientId());
        requisites.setBankName(requisitesEntity.getBankName());
        requisites.setAddress(requisitesEntity.getAddress());
        requisites.businessAddress(requisitesEntity.getBusinessAddress());
        requisites.setCreated(requisitesEntity.getCreated());
        requisites.setUpdated(requisitesEntity.getUpdated());
        return requisites;
    }
}
