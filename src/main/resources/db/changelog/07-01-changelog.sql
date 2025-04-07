-- liquibase formatted sql

-- changeset Oleg:1744040363666-1
CREATE SEQUENCE IF NOT EXISTS client_seq START WITH 1 INCREMENT BY 50;

-- changeset Oleg:1744040363666-2
CREATE TABLE client
(
    id   INTEGER     NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

-- changeset Oleg:1744040363666-3
ALTER TABLE requisites
    ADD requisites_id INTEGER;

-- changeset Oleg:1744040363666-4
ALTER TABLE requisites
    ADD CONSTRAINT FK_REQUISITES_ON_REQUISITES FOREIGN KEY (requisites_id) REFERENCES client (id);

