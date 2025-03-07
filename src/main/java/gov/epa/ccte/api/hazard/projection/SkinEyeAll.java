package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.SkinEye} entity
 */
public interface SkinEyeAll {
	
    Integer getId();
    
    String getAuthority();
    
    String getClassification();
    
    String getDtxsid();
    
    String getEndpoint();
    
    String getGlp();
    
    String getGuideline();
    
    String getRecordUrl();
    
    String getReliability();   
    
    String getResultText();
    
    String getScore();
    
    String getSkinEyeHash();
    
    String getSkinEyeId();
    
    String getSkinEyeUuid();
    
    String getSource();

    String getSpecies();

    String getStrain();
    
    String getStudyType();
    
    Integer getYear();

}