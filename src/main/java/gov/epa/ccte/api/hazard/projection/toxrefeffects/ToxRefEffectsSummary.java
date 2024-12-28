package gov.epa.ccte.api.hazard.projection.toxrefeffects;

import gov.epa.ccte.api.hazard.domain.ToxRefEffects;

/**
 * Projection for selection {@link ToxRefEffects}
 */
public interface ToxRefEffectsSummary {
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
