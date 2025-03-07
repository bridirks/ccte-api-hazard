package gov.epa.ccte.api.hazard.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.ToxValDb} entity
 */
@Data
public class ToxValDbDto implements Serializable {
    
    @NotNull
    private final Integer id;
    @Size(max = 45)
    private final String dtxsid;
    private final String casrn;
    private final String name;
    @Size(max = 255)
    private final String source;
    @Size(max = 255)
    private final String subsource;
    @Size(max = 255)
    private final String toxvalType;
    private final String toxvalTypeDefinition;
    @Size(max = 255)
    private final String toxvalSubtype;
    @Size(max = 255)
    private final String toxvalTypeSuperCategory;
    @Size(max = 255)
    private final String qualifier;
    private final Double toxvalNumeric;
    @Size(max = 255)
    private final String toxvalUnits;
    @Size(max = 255)
    private final String riskAssessmentClass;
    @Size(max = 255)
    private final String humanEco;
    @Size(max = 255)
    private final String studyType;
    @Size(max = 255)
    private final String studyDurationClass;
    private final Double studyDurationValue;
    @Size(max = 255)
    private final String studyDurationUnits;
    @Size(max = 255)
    private final String speciesCommon;
    @Size(max = 255)
    private final String strain;
    @Size(max = 255)
    private final String latinName;
    @Size(max = 255)
    private final String speciesSupercategory;
    @Size(max = 255)
    private final String sex;
    @Size(max = 255)
    private final String generation;
    @Size(max = 255)
    private final String lifestage;
    @Size(max = 255)
    private final String exposureRoute;
    @Size(max = 255)
    private final String exposureMethod;
    @Size(max = 255)
    private final String exposureForm;
    @Size(max = 255)
    private final String media;
    private final String toxicologicalEffect;
    private final String experimentalRecord;
    @Size(max = 255)
    private final String studyGroup;
    private final String longRef;
    private final String doi;
    private final String title;
    @Size(max = 255)
    private final String author;
    @Size(max = 255)
    private final String year;
    @Size(max = 255)
    private final String guideline;
    @Size(max = 255)
    private final String quality;
    private final String qcCategory;
    @Size(max = 45)
    private final String sourceHash;
    private final String externalSourceId;
    private final String externalSourceIdDesc;
    @Size(max = 255)
    private final String sourceUrl;
    @Size(max = 255)
    private final String subsourceUrl;
    @Size(max = 255)
    private final String storedSourceRecord;
    @Size(max = 255)
    private final String toxvalTypeOriginal;
    @Size(max = 255)
    private final String toxvalSubtypeOriginal;
    @Size(max = 255)
    private final Double toxvalNumericOriginal;
    @Size(max = 255)
    private final String toxvalUnitsOriginal;
    @Size(max = 255)
    private final String studyTypeOriginal;
    @Size(max = 255)
    private final String studyDurationClassOriginal;
    @Size(max = 255)
    private final String studyDurationValueOriginal;
    @Size(max = 255)
    private final String studyDurationUnitsOriginal;
    @Size(max = 255)
    private final String speciesOriginal;
    @Size(max = 255)
    private final String strainOriginal;
    @Size(max = 255)
    private final String sexOriginal;
    @Size(max = 255)
    private final String generationOriginal;
    @Size(max = 255)
    private final String lifestageOriginal;
    @Size(max = 255)
    private final String exposureRouteOriginal;
    @Size(max = 255)
    private final String exposureMethodOriginal;
    @Size(max = 255)
    private final String exposureFormOriginal;
    @Size(max = 255)
    private final String mediaOriginal;
    private final String toxicologicalEffectOriginal;
    @Size(max = 255)
    private final String originalYear;
}

