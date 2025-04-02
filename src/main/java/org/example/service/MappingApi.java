package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ApiDto;
import org.example.model.Requisites;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MappingApi {
    private final RequisitesTransaction requisitesTransaction;
    public ApiDto getRequisitesApiId(String externalId) {
        Requisites requisites = requisitesTransaction.readById(externalId);
            ApiDto apiDto = getRequisites(requisites);
        return apiDto;
    }
    public List<ApiDto> getRequisitesApiIds() {
        List<Requisites> requisitesList = requisitesTransaction.readAll();
        List<ApiDto> apiDtos = requisitesList.parallelStream().map(this::getRequisites).
                collect(Collectors.toList());
    return apiDtos;
    }
    public ApiDto getRequisites(Requisites requisites){
           ApiDto apiDto= ApiDto.builder().
                id(requisites.getId()).
                externalId(requisites.getExternalId()).
                client_id(requisites.getClient_id()).
                name_company(requisites.getName_company()).
                ogrn(requisites.getOgrn()).
                inn(requisites.getInn()).
                kpp(requisites.getKpp()).
                bank_name(requisites.getBank_name()).
                rcbic(requisites.getRcbic()).
                corr_ass(requisites.getCorr_ass()).
                ass(requisites.getAss()).
                address(requisites.getAddress()).
                business_address(requisites.getBusiness_address()).
                created(requisites.getCreated()).
                updated(requisites.getUpdated()).
                build();
           return apiDto;
    }
    }
