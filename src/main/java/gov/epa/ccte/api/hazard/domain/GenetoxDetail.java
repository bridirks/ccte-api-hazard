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
@Table(name = "genetox_details", schema = "ms")
public class GenetoxDetail {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "dtxsid")
    @Schema(description = "Distributed Structure-Searchable Toxicity (DSSTox) id")
    private String dtxsid;

    @Size(max = 45)
    @Column(name = "source", length = 45)
    @Schema(description = "Originator of source data")
    private String source;

    @Size(max = 45)
    @Column(name = "assay_category", length = 45)
    @Schema(description = "Category of assay: in vitro or in vivo")
    private String assayCategory;

    @Size(max = 255)
    @Column(name = "assay_type")
    @Schema(description = "Type of genotoxicity assay")
    private String assayType;

    @Size(max = 45)
    @Column(name = "metabolic_activation", length = 45)
    @Schema(description = "Indicator if assay included metabolic activation")
    private String metabolicActivation;

    @Size(max = 45)
    @Column(name = "species", length = 45)
    @Schema(description = "Species of the animal test subject used in a study")
    private String species;

    @Size(max = 255)
    @Column(name = "strain")
    @Schema(description = "Intraspecific description of group of animals used in a study; generally, a stock of animals that share a uniform morphological or physiological character, or group that is genetically uniform")
    private String strain;

    @Size(max = 45)
    @Column(name = "assay_result", length = 45)
    @Schema(description = "Result in assay (positive, negative, or other)")
    private String assayResult;

    @Column(name = "year")
    @Schema(description = "Year in which the study was reported as finished")
    private Integer year;

    @Column(name = "rn")
    private Long rn;


}