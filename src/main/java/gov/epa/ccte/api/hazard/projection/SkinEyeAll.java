package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.SkinEye} entity
 */
public interface SkinEyeAll {
    Integer getId();

    String getDtxsid();

    String getSource();

    String getStudyType();

    String getSpecies();

    String getStrain();

    String getReliability();

    String getEndpoint();

    String getScore();

    Integer getYear();

    String getGuideline();

    String getClassification();

    String getResultText();
}