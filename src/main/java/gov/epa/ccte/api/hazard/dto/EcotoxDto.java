package gov.epa.ccte.api.hazard.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.Ecotox} entity
 */
@Data
public class EcotoxDto {

    @NotNull
    private final Integer id;

    @Size(max = 120)
    private String author;

    private Integer casNumber;

    @Size(max = 240)
    private String chemicalAnalysisMethod;

    @Size(max = 1000)
    private String chemicalGrade;

    @Size(max = 1000)
    private String chemicalName;

    @Size(max = 4000)
    private String chemicalPurity;

    private String concOneAuthor;

    @Size(max = 21)
    private String concOneMax;

    @Size(max = 2)
    private String concOneMaxOp;

    @Size(max = 21)
    private String concOneMean;

    @Size(max = 2)
    private String concOneMeanOp;

    @Size(max = 1000)
    private String concOneMeanStd;

    @Size(max = 21)
    private String concOneMin;

    @Size(max = 2)
    private String concOneMinOp;

    @Size(max = 1000)
    private String concOneTypeStd;

    @Size(max = 20)
    private String concOneUnitsAuthor;

    @Size(max = 1000)
    private String concOneUnitsStd;

    @Size(max = 240)
    private String controlType;

    @Size(max = 255)
    private String dsstoxCasrn;

    @Size(max = 45)
    private String dsstoxCompoundId;

    @Size(max = 255)
    private String dsstoxPreferredName;

    @Size(max = 45)
    private String dtxsid;

    @Size(max = 240)
    private String effect;

    private String effectGroupLevel;

    @Size(max = 240)
    private String effectMeasurement;

    @Size(max = 240)
    private String endpoint;

    private String exposureGroup;

    @Size(max = 960)
    private String exposureType;

    private String habitat;

    @Size(max = 240)
    private String mediaType;

    @Size(max = 255)
    private String molFrml;

    private Integer ncbiTaxId;

    @Size(max = 4000)
    private String numberDoses;

    @Size(max = 11)
    private String observDurationMax;

    @Size(max = 2)
    private String observDurationMaxOp;

    @Size(max = 11)
    private String observDurationMean;

    @Size(max = 2)
    private String observDurationMeanOp;

    @Size(max = 11)
    private String observDurationMin;

    @Size(max = 2)
    private String observDurationMinOp;

    @Size(max = 20)
    private String observDurationUnit;

    @Size(max = 240)
    private String observDurationUnitDesc;

    private String observDurationStd;

    @Size(max = 4000)
    private String observDurationUnitsStd;

    @Size(max = 1000)
    private String organismAge;

    @Size(max = 240)
    private String organismAgeUnits;

    @Size(max = 240)
    private String organismLifestage;

    @Size(max = 4)
    private String publicationYear;

    private Integer referenceNumber;

    @Size(max = 240)
    private String responseSite;

    private Integer resultNumber;

    @Size(max = 20)
    private String resultSampleUnit;

    @Size(max = 240)
    private String resultSampleUnitDesc;

    @Size(max = 255)
    private String source;

    @Size(max = 60)
    private String speciesCommonName;

    @Size(max = 1000)
    private String speciesGroup;

    private Integer speciesNumber;

    @Size(max = 1000)
    private String speciesScientificName;

    private String summaryAdditionalParameters;

    @Size(max = 1000)
    private String testLocation;

    @Size(max = 4000)
    private String testMethodComment;

    private Integer testNumber;

    @Size(max = 220)
    private String title;
}
