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

create table ms.genetox_details
(
    id                   integer,
    dtxsid               varchar(255),
    source               varchar(45),
    assay_category       varchar(45),
    assay_type           varchar(255),
    metabolic_activation varchar(45),
    species              varchar(45),
    strain               varchar(255),
    assay_result         varchar(45),
    year                 integer,
    rn                   bigint
);

create table ms.genetox_summary
(
    id            integer,
    dtxsid        varchar(255),
    reports_pos   integer,
    reports_neg   integer,
    reports_other integer,
    ames          varchar(255),
    micronucleus  varchar(255),
    rn            bigint
);

create table ms.hazard
(
    id                       serial,
    dtxsid                   varchar(45),
    priority_id              integer,
    source                   varchar(255),
    subsource                varchar(255),
    source_url               varchar(255),
    subsource_url            varchar(255),
    risk_assessment_class    varchar(255),
    toxval_type              varchar(255),
    toxval_subtype           varchar(255),
    toxval_numeric           double precision,
    toxval_numeric_qualifier varchar(255),
    toxval_units             varchar(255),
    study_type               varchar(255),
    study_duration_class     varchar(255),
    study_duration_value     double precision,
    study_duration_units     varchar(255),
    strain                   varchar(255),
    sex                      varchar(255),
    population               varchar(255),
    exposure_route           varchar(255),
    exposure_method          varchar(255),
    exposure_form            varchar(255),
    media                    varchar(255),
    lifestage                varchar(255),
    generation               varchar(255),
    study_year               varchar(255),
    critical_effect          varchar,
    detail_text              varchar(255),
    supercategory            varchar(255),
    species_common           varchar(255),
    human_eco_nt             varchar(255),
    created_by               varchar(50) default "current_user"(),
    created_at               timestamp   default now()
);

create table ms.skin_eye
(
    id             integer,
    dtxsid         varchar(255),
    source         varchar(45),
    study_type     varchar(255),
    species        varchar(255),
    strain         varchar(255),
    reliability    varchar(45),
    endpoint       varchar(45),
    guideline      varchar(1024),
    result_text    varchar(1024),
    classification varchar(255),
    score          varchar(45),
    year           integer,
    rn             bigint
);








