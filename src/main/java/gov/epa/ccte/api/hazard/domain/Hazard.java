package gov.epa.ccte.api.hazard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hazard")
public class Hazard {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "dtxsid", length = 45)
    private String dtxsid;

    @Column(name = "priority_id")
    private Integer priorityId;

    @Size(max = 255)
    @Column(name = "source")
    private String source;

    @Size(max = 255)
    @Column(name = "subsource")
    private String subsource;

    @Size(max = 255)
    @Column(name = "source_url")
    private String sourceUrl;

    @Size(max = 255)
    @Column(name = "subsource_url")
    private String subsourceUrl;

    @Size(max = 255)
    @Column(name = "risk_assessment_class")
    private String riskAssessmentClass;

    @Size(max = 255)
    @Column(name = "toxval_type")
    private String toxvalType;

    @Size(max = 255)
    @Column(name = "toxval_subtype")
    private String toxvalSubtype;

    @Column(name = "toxval_numeric")
    private Double toxvalNumeric;

    @Size(max = 255)
    @Column(name = "toxval_numeric_qualifier")
    private String toxvalNumericQualifier;

    @Size(max = 255)
    @Column(name = "toxval_units")
    private String toxvalUnits;

    @Size(max = 255)
    @Column(name = "study_type")
    private String studyType;

    @Size(max = 255)
    @Column(name = "study_duration_class")
    private String studyDurationClass;

    @Column(name = "study_duration_value")
    private Double studyDurationValue;

    @Size(max = 255)
    @Column(name = "study_duration_units")
    private String studyDurationUnits;

    @Size(max = 255)
    @Column(name = "strain")
    private String strain;

    @Size(max = 255)
    @Column(name = "sex")
    private String sex;

    @Size(max = 255)
    @Column(name = "population")
    private String population;

    @Size(max = 255)
    @Column(name = "exposure_route")
    private String exposureRoute;

    @Size(max = 255)
    @Column(name = "exposure_method")
    private String exposureMethod;

    @Size(max = 255)
    @Column(name = "exposure_form")
    private String exposureForm;

    @Size(max = 255)
    @Column(name = "media")
    private String media;

    @Size(max = 255)
    @Column(name = "lifestage")
    private String lifestage;

    @Size(max = 255)
    @Column(name = "generation")
    private String generation;

    @Size(max = 255)
    @Column(name = "study_year")
    private String year;

    @Size(max = 1024)
    @Column(name = "critical_effect", length = 1024)
    private String criticalEffect;

    @Size(max = 255)
    @Column(name = "detail_text")
    private String detailText;

    @Size(max = 255)
    @Column(name = "supercategory")
    private String supercategory;

    @Size(max = 255)
    @Column(name = "species_common")
    private String speciesCommon;

    @Size(max = 255)
    @Column(name = "human_eco_nt")
    private String humanEcoNt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtxsid() {
        return dtxsid;
    }

    public void setDtxsid(String dtxsid) {
        this.dtxsid = dtxsid;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubsource() {
        return subsource;
    }

    public void setSubsource(String subsource) {
        this.subsource = subsource;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSubsourceUrl() {
        return subsourceUrl;
    }

    public void setSubsourceUrl(String subsourceUrl) {
        this.subsourceUrl = subsourceUrl;
    }

    public String getRiskAssessmentClass() {
        return riskAssessmentClass;
    }

    public void setRiskAssessmentClass(String riskAssessmentClass) {
        this.riskAssessmentClass = riskAssessmentClass;
    }

    public String getToxvalType() {
        return toxvalType;
    }

    public void setToxvalType(String toxvalType) {
        this.toxvalType = toxvalType;
    }

    public String getToxvalSubtype() {
        return toxvalSubtype;
    }

    public void setToxvalSubtype(String toxvalSubtype) {
        this.toxvalSubtype = toxvalSubtype;
    }

    public Double getToxvalNumeric() {
        return toxvalNumeric;
    }

    public void setToxvalNumeric(Double toxvalNumeric) {
        this.toxvalNumeric = toxvalNumeric;
    }

    public String getToxvalNumericQualifier() {
        return toxvalNumericQualifier;
    }

    public void setToxvalNumericQualifier(String toxvalNumericQualifier) {
        this.toxvalNumericQualifier = toxvalNumericQualifier;
    }

    public String getToxvalUnits() {
        return toxvalUnits;
    }

    public void setToxvalUnits(String toxvalUnits) {
        this.toxvalUnits = toxvalUnits;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudyDurationClass() {
        return studyDurationClass;
    }

    public void setStudyDurationClass(String studyDurationClass) {
        this.studyDurationClass = studyDurationClass;
    }

    public Double getStudyDurationValue() {
        return studyDurationValue;
    }

    public void setStudyDurationValue(Double studyDurationValue) {
        this.studyDurationValue = studyDurationValue;
    }

    public String getStudyDurationUnits() {
        return studyDurationUnits;
    }

    public void setStudyDurationUnits(String studyDurationUnits) {
        this.studyDurationUnits = studyDurationUnits;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getExposureRoute() {
        return exposureRoute;
    }

    public void setExposureRoute(String exposureRoute) {
        this.exposureRoute = exposureRoute;
    }

    public String getExposureMethod() {
        return exposureMethod;
    }

    public void setExposureMethod(String exposureMethod) {
        this.exposureMethod = exposureMethod;
    }

    public String getExposureForm() {
        return exposureForm;
    }

    public void setExposureForm(String exposureForm) {
        this.exposureForm = exposureForm;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getLifestage() {
        return lifestage;
    }

    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCriticalEffect() {
        return criticalEffect;
    }

    public void setCriticalEffect(String criticalEffect) {
        this.criticalEffect = criticalEffect;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public String getSupercategory() {
        return supercategory;
    }

    public void setSupercategory(String supercategory) {
        this.supercategory = supercategory;
    }

    public String getSpeciesCommon() {
        return speciesCommon;
    }

    public void setSpeciesCommon(String speciesCommon) {
        this.speciesCommon = speciesCommon;
    }

    public String getHumanEcoNt() {
        return humanEcoNt;
    }

    public void setHumanEcoNt(String humanEcoNt) {
        this.humanEcoNt = humanEcoNt;
    }

}