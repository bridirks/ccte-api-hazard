package gov.epa.ccte.api.hazard.projection;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.GenetoxDetail} entity
 */
public interface GenetoxDetailAll {
    Integer getId();

    String getDtxsid();

    String getSource();

    String getAssayCategory();

    String getAssayType();

    String getMetabolicActivation();

    String getSpecies();

    String getStrain();

    String getAssayResult();

    Integer getYear();

    Long getRn();
}