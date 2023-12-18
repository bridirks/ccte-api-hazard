package gov.epa.ccte.api.hazard.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.Ecotox} entity
 */
@Data
public class EcotoxDto {

    @NotNull
    private final Integer id;
    @Size(max = 120)
    private final String author;
    private final Integer casNumber;
    @Size(max = 240)
    private final String chemicalAnalysisMethod;
    @Size(max = 1000)
    private final String chemicalGrade;
    @Size(max = 1000)
    private final String chemicalName;
    @Size(max = 4000)
    private final String chemicalPurity;
    private final String concOneAuthor;
    @Size(max = 21)
    private final String concOneMax;
    @Size(max = 2)
    private final String concOneMaxOp;
    @Size(max = 21)
    private final String concOneMean;
    @Size(max = 2)
    private final String concOneMeanOp;
    @Size(max = 1000)
    private final String concOneMeanStd;
    @Size(max = 21)
    private final String concOneMin;
    @Size(max = 2)
    private final String concOneMinOp;
    @Size(max = 1000)
    private final String concOneTypeStd;
    @Size(max = 20)
    private final String concOneUnitsAuthor;
    @Size(max = 1000)
    private final String concOneUnitsStd;
    @Size(max = 240)
    private final String controlType;
    @Size(max = 255)
    private final String dsstoxCasrn;
    @Size(max = 45)
    private final String dsstoxCompoundId;
    @Size(max = 255)
    private final String dsstoxPreferredName;
    @Size(max = 45)
    private final String dtxsid;
    @Size(max = 240)
    private final String effect;
    private final String effectGroupLevel;
    @Size(max = 240)
    private final String effectMeasurement;
    @Size(max = 240)
    private final String endpoint;
    private final String exposureGroup;
    @Size(max = 960)
    private final String exposureType;
    private final String habitat;
    @Size(max = 240)
    private final String mediaType;
    @Size(max = 255)
    private final String molFrml;
    private final Integer ncbiTaxId;
    @Size(max = 4000)
    private final String numberDoses;
    @Size(max = 11)
    private final String observDurationMax;
    @Size(max = 2)
    private final String observDurationMaxOp;
    @Size(max = 11)
    private final String observDurationMean;
    @Size(max = 2)
    private final String observDurationMeanOp;
    @Size(max = 11)
    private final String observDurationMin;
    @Size(max = 2)
    private final String observDurationMinOp;
    @Size(max = 20)
    private final String observDurationUnit;
    @Size(max = 240)
    private final String observDurationUnitDesc;
    private final String observDurationStd;
    @Size(max = 4000)
    private final String observDurationUnitsStd;
    @Size(max = 1000)
    private final String organismAge;
    @Size(max = 240)
    private final String organismAgeUnits;
    @Size(max = 240)
    private final String organismLifestage;
    @Size(max = 4)
    private final String publicationYear;
    private final Integer referenceNumber;
    @Size(max = 240)
    private final String responseSite;
    private final Integer resultNumber;
    @Size(max = 20)
    private final String resultSampleUnit;
    @Size(max = 240)
    private final String resultSampleUnitDesc;
    @Size(max = 255)
    private final String source;
    @Size(max = 60)
    private final String speciesCommonName;
    @Size(max = 1000)
    private final String speciesGroup;
    private final Integer speciesNumber;
    @Size(max = 1000)
    private final String speciesScientificName;
    private final String summaryAdditionalParameters;
    @Size(max = 1000)
    private final String testLocation;
    @Size(max = 4000)
    private final String testMethodComment;
    private final Integer testNumber;
    @Size(max = 220)
    private final String title;
}
