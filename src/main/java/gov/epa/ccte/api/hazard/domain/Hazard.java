package gov.epa.ccte.api.hazard.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author arashid
 * Create at 2022-09-26 18:44
 */
@Entity
@Table(name = "hazard")
@Data
@RequiredArgsConstructor
public class Hazard {

    /**
     * 
     */
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 
     */
    @Column(name = "dtxsid", length = 45)
    private String dtxsid;

    /**
     * 
     */
    @Column(name = "priority_id")
    private Integer priorityId;

    /**
     * 
     */
    @Column(name = "source")
    private String source;

    /**
     * 
     */
    @Column(name = "subsource")
    private String subsource;

    /**
     * 
     */
    @Column(name = "source_url")
    private String sourceUrl;

    /**
     * 
     */
    @Column(name = "subsource_url")
    private String subsourceUrl;

    /**
     * 
     */
    @Column(name = "risk_assessment_class")
    private String riskAssessmentClass;

    /**
     * 
     */
    @Column(name = "toxval_type")
    private String toxvalType;

    /**
     * 
     */
    @Column(name = "toxval_subtype")
    private String toxvalSubtype;

    /**
     * 
     */
    @Column(name = "toxval_numeric")
    private Double toxvalNumeric;

    /**
     * 
     */
    @Column(name = "toxval_numeric_qualifier")
    private String toxvalNumericQualifier;

    /**
     * 
     */
    @Column(name = "toxval_units")
    private String toxvalUnits;

    /**
     * 
     */
    @Column(name = "study_type")
    private String studyType;

    /**
     * 
     */
    @Column(name = "study_duration_class")
    private String studyDurationClass;

    /**
     * 
     */
    @Column(name = "study_duration_value")
    private Double studyDurationValue;

    /**
     * 
     */
    @Column(name = "study_duration_units")
    private String studyDurationUnits;

    /**
     * 
     */
    @Column(name = "strain")
    private String strain;

    /**
     * 
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 
     */
    @Column(name = "population")
    private String population;

    /**
     * 
     */
    @Column(name = "exposure_route")
    private String exposureRoute;

    /**
     * 
     */
    @Column(name = "exposure_method")
    private String exposureMethod;

    /**
     * 
     */
    @Column(name = "exposure_form")
    private String exposureForm;

    /**
     * 
     */
    @Column(name = "media")
    private String media;

    /**
     * 
     */
    @Column(name = "lifestage")
    private String lifestage;

    /**
     * 
     */
    @Column(name = "generation")
    private String generation;

    /**
     * 
     */
    @Column(name = "year")
    private String year;

    /**
     * 
     */
    @Column(name = "critical_effect", length = 1024)
    private String criticalEffect;

    /**
     * 
     */
    @Column(name = "detail_text")
    private String detailText;

    /**
     * 
     */
    @Column(name = "supercategory")
    private String supercategory;

    /**
     * 
     */
    @Column(name = "species_common")
    private String speciesCommon;

    /**
     * 
     */
    @Column(name = "human_eco_nt")
    private String humanEcoNt;

//    /**
//     *
//     */
//    @Column(name = "created_by", length = 50)
//    private String createdBy;
//
//    /**
//     *
//     */
//    @Column(name = "created_at")
//    private OffsetDateTime createdAt;
}