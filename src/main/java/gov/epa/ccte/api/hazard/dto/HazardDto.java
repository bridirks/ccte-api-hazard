package gov.epa.ccte.api.hazard.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.Hazard} entity
 */
@Data
public class HazardDto implements Serializable {

    @NotNull
    private final Integer id;
    @Size(max = 45)
    private final String dtxsid;
    private final Integer priorityId;
    @Size(max = 255)
    private final String source;
    @Size(max = 255)
    private final String subsource;
    @Size(max = 255)
    private final String sourceUrl;
    @Size(max = 255)
    private final String subsourceUrl;
    @Size(max = 255)
    private final String riskAssessmentClass;
    @Size(max = 255)
    private final String toxvalType;
    @Size(max = 255)
    private final String toxvalSubtype;
    private final Double toxvalNumeric;
    @Size(max = 255)
    private final String toxvalNumericQualifier;
    @Size(max = 255)
    private final String toxvalUnits;
    @Size(max = 255)
    private final String studyType;
    @Size(max = 255)
    private final String studyDurationClass;
    private final Double studyDurationValue;
    @Size(max = 255)
    private final String studyDurationUnits;
    @Size(max = 255)
    private final String strain;
    @Size(max = 255)
    private final String sex;
    @Size(max = 255)
    private final String population;
    @Size(max = 255)
    private final String exposureRoute;
    @Size(max = 255)
    private final String exposureMethod;
    @Size(max = 255)
    private final String exposureForm;
    @Size(max = 255)
    private final String media;
    @Size(max = 255)
    private final String lifestage;
    @Size(max = 255)
    private final String generation;
    @Size(max = 255)
    private final String year;
    @Size(max = 1024)
    private final String criticalEffect;
    @Size(max = 255)
    private final String detailText;
    @Size(max = 255)
    private final String supercategory;
    @Size(max = 255)
    private final String speciesCommon;
    @Size(max = 255)
    private final String humanEcoNt;
}