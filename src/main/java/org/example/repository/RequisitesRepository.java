package org.example.repository;

import org.example.model.Requisites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequisitesRepository extends JpaRepository<Requisites, String> {
Requisites findByExternalId(String externalId);

}
