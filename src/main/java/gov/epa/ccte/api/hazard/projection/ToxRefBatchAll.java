package gov.epa.ccte.api.hazard.projection;

public interface ToxRefBatchAll {

    Integer getStudyId();

    String getDtxsid();

    String getCasrn();

    String getName();

    String getStudySource();

    String getStudySourceId();

    String getCitation();

    String getStudyYear();

    String getStudyType();

    String getStudyTypeGuideline();

    String getSpecies();

    String getStrainGroup();

    String getStrain();

    String getAdminRoute();

    String getAdminMethod();

    String getDoseDuration();

    String getDoseDurationUnit();

    Integer getDoseStart();

    String getDoseStartUnit();

    Integer getDoseEnd();

    String getDoseEndUnit();

    String getDosePeriod();

    Integer getDoseLevel();

    String getConc();

    String getConcUnit();

    String getVehicle();

    String getDoseComment();

    String getDoseAdjusted();

    String getDoseAdjustedUnit();

    String getSex();

    String getGeneration();

    String getLifeStage();

    String getNumAnimals();

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

    String getTreatmentRelated();

    Boolean getCriticalEffect();

    String getSampleSize();

    String getEffectVal();

    String getEffectValUnit();

    String getEffectVar();

    String getEffectVarType();

    String getTime();

    String getTimeUnit();

    Long getTbsKey();

}
