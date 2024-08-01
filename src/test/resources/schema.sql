-- create schema
create schema ms;

-- create tables
create table ms.cancer_summary
(
    dtxsid         varchar(255),
    source         varchar(255),
    exposure_route varchar(255),
    cancer_call    varchar(255),
    url            varchar(255),
    rn             bigint,
    id             integer
);


