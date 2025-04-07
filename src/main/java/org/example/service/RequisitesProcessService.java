package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.event.EventRequisites;
import org.example.model.Requisites;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitesProcessService {
    private final RequisitesTransaction requisitesTransaction;
public void processRequisites(EventRequisites eventRequisites) {
 Requisites requisites=requisitesTransaction.readById(eventRequisites.getExternalId());
     if (requisites!=null) {
          requisites.setClientId(eventRequisites.getClientId());
          requisites.setExternalId(eventRequisites.getExternalId());
          requisites.setAddress(eventRequisites.getAddress());
          requisites.setBusinessAddress(eventRequisites.getBusinessAddress());
          requisites.setAss(eventRequisites.getAss());
          requisites.setCorrAss(eventRequisites.getCorrAss());
          requisites.setBankName(eventRequisites.getBankName());
          requisites.setKpp(eventRequisites.getKpp());
          requisites.setInn(eventRequisites.getInn());
          requisites.setOgrn(eventRequisites.getOgrn());
          requisites.setRcbic(eventRequisites.getRcbic());
          requisites.setNameCompany(eventRequisites.getNameCompany());
Requisites savedRequisites = requisitesTransaction.savedRequisites(requisites,eventRequisites.getRequisitesId());
}else {
          Requisites requisites1 = Requisites.builder().
                  clientId(eventRequisites.getClientId()).
                  externalId(eventRequisites.getExternalId()).
                  address(eventRequisites.getAddress()).
                  businessAddress(eventRequisites.getBusinessAddress()).
                  ass(eventRequisites.getAss()).
                  corrAss(eventRequisites.getCorrAss()).
                  bankName(eventRequisites.getBankName()).
                  kpp(eventRequisites.getKpp()).
                  inn(eventRequisites.getInn()).
                  ogrn(eventRequisites.getOgrn()).
                  rcbic(eventRequisites.getRcbic()).
                  nameCompany(eventRequisites.getNameCompany()).build();
          Requisites savedRequisites = requisitesTransaction.savedRequisites(requisites1,eventRequisites.getRequisitesId());
     }
  }
}
