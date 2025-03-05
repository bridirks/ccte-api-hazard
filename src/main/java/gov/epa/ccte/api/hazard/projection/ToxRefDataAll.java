package gov.epa.ccte.api.hazard.projection;

import gov.epa.ccte.api.hazard.domain.ToxRefData;

/**
 * Projection for {@link ToxRefData}
 */

public interface ToxRefDataAll {
    Integer getStudyId();

    String getDtxsid();

    String getCasrn();

    String getName();

    String getStudySource();

    String getStudySourceId();

    String getCitation();

    Integer getStudyYear();

    String getStudyType();

    String getStudyTypeGuideline();

    String getSpecies();

    String getStrainGroup();

    String getStrain();

    String getAdminRoute();

    String getAdminMethod();

    Integer getDoseDuration();

    String getDoseDurationUnit();

    Integer getDoseStart();

    String getDoseStartUnit();

    Integer getDoseEnd();

    String getDoseEndUnit();

    String getDosePeriod();

    Integer getDoseLevel();

    Double getConc();

    String getConcUnit();

    String getVehicle();

    String getDoseComment();

    java.math.BigDecimal getDoseAdjusted();

    String getDoseAdjustedUnit();

    String getSex();

    String getGeneration();

    String getLifeStage();

    java.math.BigDecimal getNumAnimals();

    String getTgComment();

    String getEndpointCategory();

    String getEndpointType();

    String getEndpointTarget();

    String getEffectDesc();

    String getEffectDescFree();

    Boolean getCancerRelated();

    String getTargetSite();

    Integer getDirection();

    String getEffectComment();

    Boolean getTreatmentRelated();

    Boolean getCriticalEffect();

    String getSampleSize();

    Double getEffectVal();

    String getEffectValUnit();

    Double getEffectVar();

    String getEffectVarType();

    Double getTime();

    String getTimeUnit();

    Boolean getNoQuantDataReported();

    java.time.LocalDate getExportDate();

    String getVersion();

}