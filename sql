CREATE DATABASE "native_binaries_benchmark"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE public.resource
(
    id bigserial NOT NULL,
    resource_string character varying(255),
    resource_text text,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.resource
    OWNER to postgres;

CREATE INDEX resource_string_idx
    ON public.resource USING hash
    (resource_string)
    TABLESPACE pg_default;


TRUNCATE resource;
ALTER SEQUENCE resource_id_seq RESTART WITH 1;
