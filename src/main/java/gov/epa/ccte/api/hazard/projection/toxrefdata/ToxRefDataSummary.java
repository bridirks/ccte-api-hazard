package gov.epa.ccte.api.hazard.projection.toxrefdata;

public interface ToxRefDataSummary {

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
}
