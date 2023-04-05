package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.SkinEye} entity
 */
public interface SkinEyeAll {
    Integer getId();

    String getClassification();

    String getDtxsid();

    String getEndpoint();

    String getGuideline();

    String getReliability();

    String getResultText();

    Long getRn();

    String getScore();

    String getSource();

    String getSpecies();

    String getStrain();

    String getStudyType();

    Integer getYear();
}