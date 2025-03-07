package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.ToxValDb} entity
 */
public interface ToxValDbAll {
    Integer getId();

    String getDtxsid();
    
    String getCasrn();
    
    String getName();

    String getSource();

    String getSubsource();

    String getToxvalType();
    
    String getToxvalTypeDefinition();

    String getToxvalSubtype();
    
    String getToxvalSubtypeDefinition();
    
    String getQualifier();

    Double getToxvalNumeric();

    String getToxvalUnits();
    
    String getRiskAssessmentClass();
    
    String getHumanEco();

    String getStudyType();

    String getStudyDurationClass();

    Double getStudyDurationValue();

    String getStudyDurationUnits();
    
    String getSpeciesCommon();

    String getStrain();
    
    String getLatinName();
    
    String getSpeciesSupercategory();

    String getSex();
    
    String getGeneration();
    
    String getLifestage();

    String getExposureRoute();

    String getExposureMethod();

    String getExposureForm();

    String getMedia();
    
    String getToxicologicalEffect();
    
    String getStudyGroup();
    
    String getLongRef();
    
    String getDoi();
    
    String getTitle();
    
    String getAuthor();
    
    String getYear();
    
    String getGuidline();
    
    String getQuality();
    
    String getQcCategory();
    
    String getSourceHash();
    
    String getExternalSourceId();
    
    String getExternalSourceIdDesc();
    
    String getSourceUrl();
    
    String getSubsourceUrl();
    
    String getStoredSourceRecord();
    
    String getToxvalTypeOriginal();
    
    String getToxvalSubtypeOriginal();
    
    Double getToxvalNumericOriginal();
    
    String getToxvalUnitsOriginal();
    
    String getstudyTypeOriginal();
    
    String getStudyDurationClassOriginal();
    
    String getStudyDurationValueOriginal();
    
    String getStudyDurationUnitsOriginal();
    
    String getSpeciesOriginal();
    
    String getStrainOriginal();
    
    String getSexOriginal();
    
    String getGenerationOriginal();
    
    String getLifestageOriginal();
    
    String getExposureRouteOriginal();
    
    String getExposureMethodOriginal();
    
    String getExposureFormOriginal();
    
    String getMediaOriginal();
    
    String getToxicologicalEffectOriginal();
    
    String getYearOriginal();

}