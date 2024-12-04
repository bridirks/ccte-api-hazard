package gov.epa.ccte.api.hazard.projection;

import gov.epa.ccte.api.hazard.domain.ToxRefObs;

/**
 * Projection for {@link ToxRefObs}
 */

public interface ToxRefObsAll {
    Integer getStudyId();

    String getDtxsid();

    String getCasrn();

    String getName();

    String getStudyType();

    String getGuidelineNumber();

    String getGuidelineName();

    String getEndpointCategory();

    String getEndpointType();

    String getEndpointTarget();

    String getStatus();

    Boolean getDefaultStatus();

    Boolean getTestedStatus();

    Boolean getReportedStatus();

    java.time.LocalDate getExportDate();

    String getVersion();
}
