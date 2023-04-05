package gov.epa.ccte.api.hazard.projection;

import java.math.BigDecimal;

/**
 * A Projection for the {@link gov.epa.ccte.api.hazard.domain.Ecotox} entity
 */
public interface Ecotox {
    Integer getId();

    String getDtxsid();

    String getDtxcid();

    String getDsstoxCasrn();

    String getDsstoxPrefNm();

    String getMolFrml();

    BigDecimal getTestNumber();

    BigDecimal getResultNumber();

    BigDecimal getSpeciesNumber();

    BigDecimal getNcbiTaxid();

    String getConc1MeanOp();

    String getConc1Mean();

    String getConc1MinOp();

    String getConc1Min();

    String getConc1MaxOp();

    String getConc1Max();

    String getAuthor();

    BigDecimal getCasNumber();

    String getChemicalAnalysisMethod();

    String getChemicalGrade();

    String getChemicalName();

    String getChemicalPurity();

    String getConc1Author();

    String getConc1MeanStd();

    String getConc1TypeStd();

    String getConc1UnitsAuthor();

    String getConc1UnitsStd();

    String getControlType();

    String getEffect();

    String getEffectMeasurement();

    String getEndpoint();

    String getExposureType();

    String getHabitat();

    String getMediaType();

    String getNumberDoses();

    String getObservedDurationStd();

    String getObservedDurationUnitsStd();

    String getOrganismAge();

    String getOrganismAgeUnits();

    String getOrganismLifestage();

    String getPublicationYear();

    BigDecimal getReferenceNumber();

    String getResponseSite();

    String getSource();

    String getSpeciesCommonName();

    String getSpeciesGroup();

    String getSpeciesScientificName();

    String getSummaryAdditionalParameters();

    String getTestLocation();

    String getTitle();

    String getExposureGroup();

    String getEffectGroupLevel();

    String getTestMethodComment();

    String getResultSampleUnit();

    String getResultSampleUnitDesc();

    String getObservDurationMeanOp();

    String getObservDurationMean();

    String getObservDurationMinOp();

    String getObservDurationMin();

    String getObservDurationMaxOp();

    String getObservDurationMax();

    String getObservDurationUnit();

    String getObservDurationUnitDesc();
}