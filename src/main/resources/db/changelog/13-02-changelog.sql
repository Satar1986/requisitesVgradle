-- liquibase formatted sql

-- changeset Oleg:1744570594912-1
ALTER TABLE requisites DROP COLUMN ass;
ALTER TABLE requisites DROP COLUMN corr_ass;

-- changeset Oleg:1744570594912-2
ALTER TABLE requisites
    ADD ass DECIMAL NOT NULL;

-- changeset Oleg:1744570594912-4
ALTER TABLE requisites
    ADD corr_ass DECIMAL NOT NULL;

