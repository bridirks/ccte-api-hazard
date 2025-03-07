package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ecotox", schema = "ms")
public class Ecotox {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "dtxsid", length = 45)
    private String dtxsid;

    @Size(max = 45)
    @Column(name = "dtxcid", length = 45)
    private String dtxcid;

    @Size(max = 255)
    @Column(name = "dsstox_casrn")
    private String dsstoxCasrn;

    @Size(max = 255)
    @Column(name = "dsstox_pref_nm")
    private String dsstoxPrefNm;

    @Size(max = 255)
    @Column(name = "mol_frml")
    private String molFrml;

    @Column(name = "test_number")
    private BigDecimal testNumber;

    @Column(name = "result_number")
    private BigDecimal resultNumber;

    @Column(name = "species_number")
    private BigDecimal speciesNumber;

    @Column(name = "ncbi_taxid")
    private BigDecimal ncbiTaxid;

    @Size(max = 2)
    @Column(name = "conc1_mean_op", length = 2)
    private String conc1MeanOp;

    @Size(max = 21)
    @Column(name = "conc1_mean", length = 21)
    private String conc1Mean;

    @Size(max = 2)
    @Column(name = "conc1_min_op", length = 2)
    private String conc1MinOp;

    @Size(max = 21)
    @Column(name = "conc1_min", length = 21)
    private String conc1Min;

    @Size(max = 2)
    @Column(name = "conc1_max_op", length = 2)
    private String conc1MaxOp;

    @Size(max = 21)
    @Column(name = "conc1_max", length = 21)
    private String conc1Max;

    @Size(max = 120)
    @Column(name = "author", length = 120)
    private String author;

    @Column(name = "cas_number")
    private BigDecimal casNumber;

    @Size(max = 240)
    @Column(name = "chemical_analysis_method", length = 240)
    private String chemicalAnalysisMethod;

    @Size(max = 1000)
    @Column(name = "chemical_grade", length = 1000)
    private String chemicalGrade;

    @Size(max = 1000)
    @Column(name = "chemical_name", length = 1000)
    private String chemicalName;

    @Size(max = 4000)
    @Column(name = "chemical_purity", length = 4000)
    private String chemicalPurity;

    @Column(name = "conc1_author")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String conc1Author;

    @Size(max = 1000)
    @Column(name = "conc1_mean_std", length = 1000)
    private String conc1MeanStd;

    @Size(max = 1000)
    @Column(name = "conc1_type_std", length = 1000)
    private String conc1TypeStd;

    @Size(max = 20)
    @Column(name = "conc1_units_author", length = 20)
    private String conc1UnitsAuthor;

    @Size(max = 1000)
    @Column(name = "conc1_units_std", length = 1000)
    private String conc1UnitsStd;

    @Size(max = 240)
    @Column(name = "control_type", length = 240)
    private String controlType;

    @Size(max = 240)
    @Column(name = "effect", length = 240)
    private String effect;

    @Size(max = 240)
    @Column(name = "effect_measurement", length = 240)
    private String effectMeasurement;

    @Size(max = 20)
    @Column(name = "endpoint", length = 20)
    private String endpoint;

    @Size(max = 960)
    @Column(name = "exposure_type", length = 960)
    private String exposureType;

    @Column(name = "habitat")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String habitat;

    @Size(max = 240)
    @Column(name = "media_type", length = 240)
    private String mediaType;

    @Size(max = 4000)
    @Column(name = "number_doses", length = 4000)
    private String numberDoses;

    @Column(name = "observed_duration_std")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String observedDurationStd;

    @Size(max = 4000)
    @Column(name = "observed_duration_units_std", length = 4000)
    private String observedDurationUnitsStd;

    @Size(max = 1000)
    @Column(name = "organism_age", length = 1000)
    private String organismAge;

    @Size(max = 240)
    @Column(name = "organism_age_units", length = 240)
    private String organismAgeUnits;

    @Size(max = 240)
    @Column(name = "organism_lifestage", length = 240)
    private String organismLifestage;

    @Size(max = 4)
    @Column(name = "publication_year", length = 4)
    private String publicationYear;

    @Column(name = "reference_number")
    private BigDecimal referenceNumber;

    @Size(max = 240)
    @Column(name = "response_site", length = 240)
    private String responseSite;

    @Size(max = 255)
    @Column(name = "source")
    private String source;

    @Size(max = 60)
    @Column(name = "species_common_name", length = 60)
    private String speciesCommonName;

    @Size(max = 1000)
    @Column(name = "species_group", length = 1000)
    private String speciesGroup;

    @Size(max = 1000)
    @Column(name = "species_scientific_name", length = 1000)
    private String speciesScientificName;

    @Column(name = "summary_additional_parameters")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String summaryAdditionalParameters;

    @Size(max = 1000)
    @Column(name = "test_location", length = 1000)
    private String testLocation;

    @Size(max = 220)
    @Column(name = "title", length = 220)
    private String title;

    @Column(name = "exposure_group")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String exposureGroup;

    @Column(name = "effect_group_level")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String effectGroupLevel;

    @Size(max = 4000)
    @Column(name = "test_method_comment", length = 4000)
    private String testMethodComment;

    @Size(max = 20)
    @Column(name = "result_sample_unit", length = 20)
    private String resultSampleUnit;

    @Size(max = 240)
    @Column(name = "result_sample_unit_desc", length = 240)
    private String resultSampleUnitDesc;

    @Size(max = 2)
    @Column(name = "observ_duration_mean_op", length = 2)
    private String observDurationMeanOp;

    @Size(max = 11)
    @Column(name = "observ_duration_mean", length = 11)
    private String observDurationMean;

    @Size(max = 2)
    @Column(name = "observ_duration_min_op", length = 2)
    private String observDurationMinOp;

    @Size(max = 11)
    @Column(name = "observ_duration_min", length = 11)
    private String observDurationMin;

    @Size(max = 2)
    @Column(name = "observ_duration_max_op", length = 2)
    private String observDurationMaxOp;

    @Size(max = 11)
    @Column(name = "observ_duration_max", length = 11)
    private String observDurationMax;

    @Size(max = 20)
    @Column(name = "observ_duration_unit", length = 20)
    private String observDurationUnit;

    @Size(max = 240)
    @Column(name = "observ_duration_unit_desc", length = 240)
    private String observDurationUnitDesc;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}