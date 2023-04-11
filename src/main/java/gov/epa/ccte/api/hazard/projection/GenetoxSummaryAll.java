package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.GenetoxSummary} entity
 */
public interface GenetoxSummaryAll {
    Integer getId();

    String getDtxsid();

    Integer getReportsPositive();

    Integer getReportsNegative();

    Integer getReportsOther();

    String getAmes();

    String getMicronucleus();

}