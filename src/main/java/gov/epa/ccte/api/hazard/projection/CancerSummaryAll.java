package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.CancerSummary} entity
 */
public interface CancerSummaryAll {

    Integer getId();
    
    String getDtxsid();

    String getSource();

    String getExposureRoute();

    String getCancerCall();
    
    String getUrl();  
    
}