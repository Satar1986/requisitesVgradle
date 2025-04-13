-- liquibase formatted sql

-- changeset Oleg:1744570168856-1
ALTER TABLE requisites
    ALTER COLUMN ass SET NOT NULL;

-- changeset Oleg:1744570168856-2
ALTER TABLE requisites
    ALTER COLUMN corr_ass SET NOT NULL;

