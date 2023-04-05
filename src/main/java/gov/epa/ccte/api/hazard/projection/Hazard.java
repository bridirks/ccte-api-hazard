package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.Hazard} entity
 */
public interface Hazard {
    Integer getId();

    String getDtxsid();

    Integer getPriorityId();

    String getSource();

    String getSubsource();

    String getSourceUrl();

    String getSubsourceUrl();

    String getRiskAssessmentClass();

    String getToxvalType();

    String getToxvalSubtype();

    Double getToxvalNumeric();

    String getToxvalNumericQualifier();

    String getToxvalUnits();

    String getStudyType();

    String getStudyDurationClass();

    Double getStudyDurationValue();

    String getStudyDurationUnits();

    String getStrain();

    String getSex();

    String getPopulation();

    String getExposureRoute();

    String getExposureMethod();

    String getExposureForm();

    String getMedia();

    String getLifestage();

    String getGeneration();

    String getYear();

    String getCriticalEffect();

    String getDetailText();

    String getSupercategory();

    String getSpeciesCommon();

    String getHumanEcoNt();
}