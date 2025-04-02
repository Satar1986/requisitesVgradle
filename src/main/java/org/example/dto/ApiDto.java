package org.example.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class ApiDto {
    private UUID id;
    private String externalId;
    private String client_id;
    private String name_company;
    private Long inn;
    private Integer kpp;
    private Long ogrn;
    private String business_address;
    private String address;
    private Integer rcbic;
    private Float corr_ass;
    private Float ass;
    private String bank_name;
    private Date created;
    private Date updated;
}
