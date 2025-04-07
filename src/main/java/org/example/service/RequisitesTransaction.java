package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Client;
import org.example.model.Requisites;
import org.example.repository.ClientRepository;
import org.example.repository.RequisitesRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequisitesTransaction {
 private final RequisitesRepository requisitesRepository;
 private final ClientRepository clientRepository;

public List<Requisites> readAll() {
    return requisitesRepository.findAll();
}
public Requisites readById(String externalId) {
 return requisitesRepository.findByExternalId(externalId);
}
public Requisites savedRequisites(Requisites requisites,Integer id) {
    return requisitesRepository.save(requisites.setClient(clientRepository.findById(id).orElseThrow(()->
            new RuntimeException("Not found" + id))));
}
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,value = "client_entity-graph")
    public List<Client> readAllClient() {
        return clientRepository.findAll();
    }
    public Client readClientById(Integer id) {
        return clientRepository.findById(id).orElseThrow(()->
                new RuntimeException("Not found" + id));
    }

}

