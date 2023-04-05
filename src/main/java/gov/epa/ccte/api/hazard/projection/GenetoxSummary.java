package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.GenetoxSummary} entity
 */
public interface GenetoxSummary {
    Integer getId();

    String getDtxsid();

    Integer getReportsPos();

    Integer getReportsNeg();

    Integer getReportsOther();

    String getAmes();

    String getMicronucleus();

    Long getRn();
}