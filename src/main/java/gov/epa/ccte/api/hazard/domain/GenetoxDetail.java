package gov.epa.ccte.api.hazard.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Description: Genotoxicity testing, also known as short-term assays, is used to evaluate the potential adverse effects of chemicals on human health. These tests can help identify carcinogens, as about 80% of known human carcinogens are genotoxic. The results of genotoxicity tests are important because of the irreversible nature and severity of the health effects that may result from genotoxic events. There are many different techniques that can be used for genotoxicity testing, notably including Ames test (comparative genetic analysis using multiple bacterial strains of Salmonella typhimurium), Comet assay (measurement DNA strand breaks), micronucleus test (cytogenetic assay that uses fluorescence in situ hybridization and chromosome painting) and chromosomal aberration test (cytogenetic assay that examines in vivo tissues to reflect how chemicals are absorbed, excreted, distributed, and metabolized). This endpoint provides detailed genotoxicity data associated to a chemical.")
@Entity
@Table(name = "mv_genetox_details", schema = "toxval")
public class GenetoxDetail {
	
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "aggregate_study_type")
    private String aggregateStudyType;
    
    @Size(max = 45)
    @Column(name = "assay_category")
    @Schema(description = "Category of assay: in vitro or in vivo")
    private String assayCategory;

    @Size(max = 45)
    @Column(name = "assay_code")
    private String assayCode;
    
    @Column(name = "assay_outcome")
    private Integer assayOutcome;
    
    @Size(max = 45)
    @Column(name = "assay_potency")
    private String assayPotency;
    
    @Size(max = 45)
    @Column(name = "assay_result")
    @Schema(description = "Result in assay (positive, negative, or other)")
    private String assayResult;

    @Size(max = 45)
    @Column(name = "assay_result_std")
    private String assayResultStd;
    
    @Size(max = 255)
    @Column(name = "assay_type")
    @Schema(description = "Type of genotoxicity assay")
    private String assayType;
    
    @Size(max = 45)
    @Column(name = "assay_type_simple_aggregate")
    @Schema(description = "Type of genotoxicity assay")
    private String assayTypeSimpleAgg;
    
    @Size(max = 255)
    @Column(name = "assay_type_standard")
    private String assayTypeStandard;
    
    @Size(max = 65)
    @Column(name = "clowder_doc_id")
    private String clowderDocId;
    
    @Column(name = "comment")
    private String comment;
    
    @Size(max = 255)
    @Column(name = "cytotoxicity")
    private String cytotoxicity;
    
    @Size(max = 45)
    @Column(name = "data_quality")
    private String dataQuality;
    
    @Size(max = 45)
    @Column(name = "document_number")
    private String documentNumber;
    
    @Size(max = 45)
    @Column(name = "document_source")
    private String documentSource;
    
    @Size(max = 45)
    @Column(name = "dose_response")
    private String doseResponse;
    
    @Size(max = 255)
    @Column(name = "dtxsid")
    @Schema(description = "Distributed Structure-Searchable Toxicity (DSSTox) id")
    private String dtxsid;
    
    @Size(max = 45)
    @Column(name = "duration")
    private String duration;
    
    @Size(max = 255)
    @Column(name = "genetox_details_hash")
    private String genetoxDetailsHash;
    
    @Column(name = "genetox_details_id")
    private Integer genetoxDetailsId;
    
    @Size(max = 255)
    @Column(name = "genetox_details_uuid")
    private String genetoxDetailsUuid;
    
    @Size(max = 255)
    @Column(name = "genetox_note")
    private String genetoxNote;
    
    @Size(max = 255)
    @Column(name = "genetox_results")
    private String genetoxResults;

    @Size(max = 45)
    @Column(name = "metabolic_activation", length = 45)
    @Schema(description = "Indicator if assay included metabolic activation")
    private String metabolicActivation;
    
    @Size(max = 255)
    @Column(name = "panel_report")
    private String panelReport;
    
    @Size(max = 45)
    @Column(name = " protocol_era")
    private String protocolEra;
    
    @Size(max = 1024)
    @Column(name = "reference")
    private String reference;
    
    @Size(max = 255)
    @Column(name = "reference_url")
    private String referenceUrl;
    
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    
    @Column(name = "smiles_2d_qsar")
    private String smiles2dQsar;
    
    @Size(max = 45)
    @Column(name = "source")
    @Schema(description = "Originator of source data")
    private String source;
    
    @Size(max = 45)
    @Column(name = "species", length = 45)
    @Schema(description = "Species of the animal test subject used in a study")
    private String species;
    
    @Size(max = 45)
    @Column(name = "species_strain", length = 45)
    private String speciesStrain;

    @Size(max = 255)
    @Column(name = "strain")
    @Schema(description = "Intraspecific description of group of animals used in a study; generally, a stock of animals that share a uniform morphological or physiological character, or group that is genetically uniform")
    private String strain;
    
    @Size(max = 1024)
    @Column(name = "title")
    private String title;

    @Column(name = "year")
    @Schema(description = "Year in which the study was reported as finished")
    private Integer year;

}