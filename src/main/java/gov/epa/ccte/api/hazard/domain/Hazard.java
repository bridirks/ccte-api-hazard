package gov.epa.ccte.api.hazard.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = " The Toxicity Values Database (ToxValDB) is a compilation of toxicity information from world-wide sites, databases, and sources, which can save the user time by providing information in one location. The data are largely limited to summary values from individual studies or chemical-level assessments, and is focused on quantitative values such as LOAELs, NOAELs, BMDs, LD50s and RfDs. The user must apply judgment in use of the information and should consult the original scientific paper or data source, if possible, to ensure an understanding of the context of the data. The ToxValDB SQL download is available at https://www.epa.gov/comptox-tools/downloadable-computational-toxicology-data#AT .")
@Entity
@Table(name = "hazard", schema = "ms")
public class Hazard {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "dtxsid", length = 45)
    @Schema(description = "Distributed Structure-Searchable Toxicity (DSSTox) id")
    private String dtxsid;

    @Column(name = "priority_id")
    @Schema(description = "(retired field)")
    private Integer priorityId;

    @Size(max = 255)
    @Column(name = "source")
    @Schema(description = "Originator of source data")
    private String source;

    @Size(max = 255)
    @Column(name = "subsource")
    @Schema(description = "Additional source reference")
    private String subsource;

    @Size(max = 255)
    @Column(name = "source_url")
    @Schema(description = "URL for source data")
    private String sourceUrl;

    @Size(max = 255)
    @Column(name = "subsource_url")
    @Schema(description = "Additional URL reference for source data")
    private String subsourceUrl;

    @Size(max = 255)
    @Column(name = "risk_assessment_class")
    @Schema(description = "Designation of cancer or non-cancer for toxicity values or media associated with exposure guideline values")
    private String riskAssessmentClass;

    @Size(max = 255)
    @Column(name = "toxval_type")
    @Schema(description = "Categorization of records based on POD or effect level. Categories include: Point of Departure (The quantitative result of an in vivo repeat dose study, such as a LOAEL, NOAEL or BMDL), Lethality Effect Level (The quantitative result of an in vivo acute study, such as a LD50 or LC50), Toxicity Value (A risk assessment summary value for a chemical, such as an RFD or cancer slope factor), Screening Level (An environmentally safe concentration, primarily EPA Regional Screening levels), Exposure Limit (Exposure levels of concern in air, water, or other media), Effect Time (A time when an effect is seen for a fixed concentration. These values all come from the ECOTOX Knowledgebase), Effect Level (A value similar to a Point of Departure, but not linked to a critical effect), Effect Dose (Similar to a Lethality Effect Level but for non-lethal ecotoxicology endpoints in acute studies), Inhibition Concentration (Similar to a Lethality Effect Level but for non-lethal ecotoxicology endpoints, focused on inhibition of growth), Other (Other uncharacterized classes of records)")
    private String toxvalType;

    @Size(max = 255)
    @Column(name = "toxval_subtype")
    @Schema(description = "Effect subtype or value subtype")
    private String toxvalSubtype;

    @Column(name = "toxval_numeric")
    @Schema(description = "Concentration of a test chemical, typically reported in ppm within the exposure matrix (e.g., feed or water), or the an adjusted amount of the chemical administered in mg/kg of body weight/day (mg/kg/day)")
    private Double toxvalNumeric;

    @Size(max = 255)
    @Column(name = "toxval_numeric_qualifier")
    @Schema(description = "Operators (<, <=, >, >=, =) to contextualize level of certainty in estimates")
    private String toxvalNumericQualifier;

    @Size(max = 255)
    @Column(name = "toxval_units")
    @Schema(description = "Unit associated with the concentration or adjusted dose of a chemical")
    private String toxvalUnits;

    @Size(max = 255)
    @Column(name = "study_type")
    @Schema(description = "Classification to describe toxicity testing that was conducted")
    private String studyType;

    @Size(max = 255)
    @Column(name = "study_duration_class")
    @Schema(description = "Categorical description of exposure duration ")
    private String studyDurationClass;

    @Column(name = "study_duration_value")
    @Schema(description = "Amount of time a group is dosed. This varies within studies depending on the dose period of a particular treatment group")
    private Double studyDurationValue;

    @Size(max = 255)
    @Column(name = "study_duration_units")
    @Schema(description = "Unit of time associated with the dose duration. Typically in days or months")
    private String studyDurationUnits;

    @Size(max = 255)
    @Column(name = "strain")
    @Schema(description = "Intraspecific description of group of animals used in a study; generally, a stock of animals that share a uniform morphological or physiological character, or group that is genetically uniform")
    private String strain;

    @Size(max = 255)
    @Column(name = "sex")
    @Schema(description = "Gender of a test animal. The gender of fetal groups is denoted as MF for both males and females")
    private String sex;

    @Size(max = 255)
    @Column(name = "population")
    @Schema(description = "Number of animals per treatment group")
    private String population;

    @Size(max = 255)
    @Column(name = "exposure_route")
    @Schema(description = "Path by which test substance was administered to animal. Options include oral, dermal, inhalation, injection, or other")
    private String exposureRoute;

    @Size(max = 255)
    @Column(name = "exposure_method")
    @Schema(description = "Specific path by which the test substance was administered via the administration route. Examples include capsule, diet, gavage, or topical")
    private String exposureMethod;

    @Size(max = 255)
    @Column(name = "exposure_form")
    @Schema(description = "The vehicle used in administration of the chemical")
    private String exposureForm;

    @Size(max = 255)
    @Column(name = "media")
    @Schema(description = "(retired field)")
    private String media;

    @Size(max = 255)
    @Column(name = "lifestage")
    @Schema(description = "Stage of life that a measurement was taken")
    private String lifestage;

    @Size(max = 255)
    @Column(name = "generation")
    @Schema(description = "Generation a test animal belongs to")
    private String generation;

    @Size(max = 255)
    @Column(name = "study_year")
    @Schema(description = "Year in which the study was reported as finished")
    private String year;

    @Size(max = 1024)
    @Column(name = "critical_effect", length = 1024)
    @Schema(description = "(renamed to toxicological effect) Treatment-associated effect ")
    private String criticalEffect;

    @Size(max = 255)
    @Column(name = "detail_text")
    @Schema(description = "(retired field)")
    private String detailText;

    @Size(max = 255)
    @Column(name = "supercategory")
    @Schema(description = "Categorization of effect or value type into one of five categories, including dose response summary value, mortality response summary value, toxicity value, media exposure guidelines, or acute exposure guidelines")
    private String supercategory;

    @Size(max = 255)
    @Column(name = "species_common")
    @Schema(description = "Species of the animal test subject used in a study")
    private String speciesCommon;

    @Size(max = 255)
    @Column(name = "human_eco_nt")
    @Schema(description = "(retired field)")
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