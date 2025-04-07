package org.example.controller;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.example.model.Requisites;
import org.example.service.RequisitesTransaction;
import org.openapi.example.api.ClientApi;
import org.openapi.example.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {
private final RequisitesTransaction requisitesTransaction;
@Override
public ResponseEntity<List<Client>> getClient() {
 List<org.example.model.Client> list=requisitesTransaction.readAllClient();
 List<Client> resultList=list.stream().map(this::getClient).collect(Collectors.toList());
    return new ResponseEntity<>(resultList, HttpStatus.OK);
}
@Override
public ResponseEntity<Client> getClientById(@Parameter(name = "id", description = "Client", required = true,
        in = ParameterIn.PATH) @PathVariable("id") Integer id) {
    org.example.model.Client client=requisitesTransaction.readClientById(id);
    Client result=getClient(client);
    return new ResponseEntity<>(result, HttpStatus.OK);
}
public Client getClient(org.example.model.Client clientEntity) {
    List<Requisites> requisitesList=clientEntity.getRequisitesList();
    List<org.openapi.example.model.Requisites>list=requisitesList.stream().map(this::getRequisites).collect(Collectors.toList());
    Client client=new Client();
    client.setId(clientEntity.getId());
    client.setName(clientEntity.getName());
    client.setRequisitesList(list);
    return client;
}
    public org.openapi.example.model.Requisites getRequisites(Requisites requisitesEntity) {
        org.openapi.example.model.Requisites requisites=new org.openapi.example.model.Requisites();
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
