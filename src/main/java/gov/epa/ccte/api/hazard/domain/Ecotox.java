package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "ecotox")
public class Ecotox {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 120)
    private String author;

    @Column(name = "cas_number")
    private Integer casNumber;

    @Size(max = 240)
    @Column(name = "chemical_analysis_method")
    private String chemicalAnalysisMethod;

    @Size(max = 1000)
    @Column(name = "chemical_grade")
    private String chemicalGrade;

    @Size(max = 1000)
    @Column(name = "chemical_name")
    private String chemicalName;

    @Size(max = 4000)
    @Column(name = "chemical_purity")
    private String chemicalPurity;

    @Column(name = "conc1_author")
    private String concOneAuthor;

    @Size(max = 21)
    @Column(name = "conc1_max")
    private String concOneMax;

    @Size(max = 2)
    @Column(name = "conc1_max_op")
    private String concOneMaxOp;

    @Size(max = 21)
    @Column(name = "conc1_mean")
    private String concOneMean;

    @Size(max = 2)
    @Column(name = "conc1_mean_op")
    private String concOneMeanOp;

    @Size(max = 1000)
    @Column(name = "conc1_mean_std")
    private String concOneMeanStd;

    @Size(max = 21)
    @Column(name = "conc1_min")
    private String concOneMin;

    @Size(max = 2)
    @Column(name = "conc1_min_op")
    private String concOneMinOp;

    @Size(max = 1000)
    @Column(name = "conc1_type_std")
    private String concOneTypeStd;

    @Size(max = 20)
    @Column(name = "conc1_units_author")
    private String concOneUnitsAuthor;

    @Size(max = 1000)
    @Column(name = "conc1_units_std")
    private String concOneUnitsStd;

    @Size(max = 240)
    @Column(name = "control_type")
    private String controlType;

    @Size(max = 255)
    @Column(name = "dsstox_casrn")
    private String dsstoxCasrn;

    @Size(max = 45)
    @Column(name = "dsstox_compound_id")
    private String dsstoxCompoundId;

    @Size(max = 255)
    @Column(name = "dsstox_pref_nm")
    private String dsstoxPreferredName;

    @Size(max = 45)
    @Column(name = "dsstox_substance_id")
    private String dtxsid;

    @Size(max = 240)
    private String effect;

    @Column(name = "effect_group_level")
    private String effectGroupLevel;

    @Size(max = 240)
    @Column(name = "effect_measurement")
    private String effectMeasurement;

    @Size(max = 240)
    private String endpoint;

    @Column(name = "exposure_group")
    private String exposureGroup;

    @Size(max = 960)
    @Column(name = "exposure_type")
    private String exposureType;

    private String habitat;

    @Size(max = 240)
    @Column(name = "media_type")
    private String mediaType;

    @Size(max = 255)
    @Column(name = "mol_frml")
    private String molFrml;

    @Column(name = "ncbi_taxid")
    private Integer ncbiTaxId;

    @Size(max = 4000)
    @Column(name = "number_doses")
    private String numberDoses;

    @Size(max = 11)
    @Column(name = "observ_duration_max")
    private String observDurationMax;

    @Size(max = 2)
    @Column(name = "observ_duration_max_op")
    private String observDurationMaxOp;

    @Size(max = 11)
    @Column(name = "observ_duration_mean")
    private String observDurationMean;

    @Size(max = 2)
    @Column(name = "observ_duration_mean_op")
    private String observDurationMeanOp;

    @Size(max = 11)
    @Column(name = "observ_duration_min")
    private String observDurationMin;

    @Size(max = 2)
    @Column(name = "observ_duration_min_op")
    private String observDurationMinOp;

    @Size(max = 20)
    @Column(name = "observ_duration_unit")
    private String observDurationUnit;

    @Size(max = 240)
    @Column(name = "observ_duration_unit_desc")
    private String observDurationUnitDesc;

    @Column(name = "observed_duration_std")
    private String observDurationStd;

    @Size(max = 4000)
    @Column(name = "observed_duration_units_std")
    private String observDurationUnitsStd;

    @Size(max = 1000)
    @Column(name = "organism_age")
    private String organismAge;

    @Size(max = 240)
    @Column(name = "organism_age_units")
    private String organismAgeUnits;

    @Size(max = 240)
    @Column(name = "organism_lifestage")
    private String organismLifestage;

    @Size(max = 4)
    @Column(name = "publication_year")
    private String publicationYear;

    @Column(name = "reference_number")
    private Integer referenceNumber;

    @Size(max = 240)
    @Column(name = "response_site")
    private String responseSite;

    @Column(name = "result_number")
    private Integer resultNumber;

    @Size(max = 20)
    @Column(name = "result_sample_unit")
    private String resultSampleUnit;

    @Size(max = 240)
    @Column(name = "result_sample_unit_desc")
    private String resultSampleUnitDesc;

    @Size(max = 255)
    private String source;

    @Size(max = 60)
    @Column(name = "species_common_name")
    private String speciesCommonName;

    @Size(max = 1000)
    @Column(name = "species_group")
    private String speciesGroup;

    @Column(name = "species_number")
    private Integer speciesNumber;

    @Size(max = 1000)
    @Column(name = "species_scientific_name")
    private String speciesScientificName;

    @Column(name = "summary_additional_parameters")
    private String summaryAdditionalParameters;

    @Size(max = 1000)
    @Column(name = "test_location")
    private String testLocation;

    @Size(max = 4000)
    @Column(name = "test_method_comment")
    private String testMethodComment;

    @Column(name = "test_number")
    private Integer testNumber;

    @Size(max = 220)
    private String title;
}
