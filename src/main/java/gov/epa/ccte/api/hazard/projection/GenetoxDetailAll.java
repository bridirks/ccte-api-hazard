package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.GenetoxDetail} entity
 */
public interface GenetoxDetailAll {
    Integer getId();
    
    String getAggregateStudyType();
    
    String getAssayCategory();
    
    String getAssayCode();
    
    Integer getAssayOutcome();
    
    String getAssayPotency();
    
    String getAssayResult();
    
    String getAssayResultStd();
    
    String getAssayType();
    
    String getAssayTypeSimpleAgg();
    
    String getAssayTypeStandard();
    
    String getClowderDocId();
    
    String getComment();
    
    String getCytotoxicity();
    
    String getDataQuality();
    
    String getDocumentNumber();
    
    String getDocumentSource();
    
    String getDoseResponse();
    
    String getDtxsid();
    
    String getDuration();
    
    String getGenetoxDetailsHash();
    
    Integer getGenetoxDetailsId();
    
    String getGenetoxDetailsUuid();
    
    String getGenetoxNote();
    
    String getGenetoxResults();
    
    String getMetabolicActivation();
    
    String getPanelReport();
    
    String getProtocolEra();
    
    String getReference();
    
    String getReferenceUrl();
    
    String getSex();
    
    Integer getSmiles2dQsar();
    
    String getSource();
    
    String getSpecies();
    
    String getSpeciesStrain();
    
    String getStrain();
    
    String getTitle();
    
    Integer getYear();
    
}