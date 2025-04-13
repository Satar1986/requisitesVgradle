package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@DynamicInsert
@DynamicUpdate
@Table(name = "requisites")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Requisites  {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id",updatable = false, nullable = false)
    private UUID id;
    @Column(name = "external_id", nullable = false,length = 50)
    private String externalId;
    @Column(name = "client_id",nullable = false,length = 20)
    private String clientId;
    @Column(name = "name_company", nullable = false,length = 50)
    private String nameCompany;
    @Column(name = "inn", nullable = false)
    private Long inn;
    @Column(name = "kpp", nullable = false)
    private Integer kpp;
    @Column(name = "ogrn", nullable = false)
    private Long ogrn;
    @Column(name = "business_address", nullable = false, length = 100)
    private String businessAddress;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "rcbic", nullable = false)
    private Integer rcbic;
    @Column(name = "corr_ass", nullable = false)
    private BigDecimal corrAss;
    @Column(name = "ass", nullable = false)
    private BigDecimal ass;
    @Column(name = "bank_name",nullable = false,length = 50)
    private String bankName;
    @Column(name = "created_time")
    private Date created;
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
    @Column(name = "updated_time")
    private Date updated;
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "requisites_id",referencedColumnName = "id")
    private Client client;

}


