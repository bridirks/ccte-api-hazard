package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.GenetoxSummary} entity
 */
public interface GenetoxSummaryAll {
    Integer getId();
    
    String getAmes();
    
    String getClowderDocId();

    String getDtxsid();
    
    String getGenetoxCall();
    
    Integer getGenetoxSummaryId();

    String getMicronucleus();

    Integer getReportsNegative();

    Integer getReportsOther();
    
    Integer getReportsPositive();

}