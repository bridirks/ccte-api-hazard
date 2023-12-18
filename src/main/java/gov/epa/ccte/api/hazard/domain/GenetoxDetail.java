package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "genetox_details", schema = "ms")
public class GenetoxDetail {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "dtxsid")
    private String dtxsid;

    @Size(max = 45)
    @Column(name = "source", length = 45)
    private String source;

    @Size(max = 45)
    @Column(name = "assay_category", length = 45)
    private String assayCategory;

    @Size(max = 255)
    @Column(name = "assay_type")
    private String assayType;

    @Size(max = 45)
    @Column(name = "metabolic_activation", length = 45)
    private String metabolicActivation;

    @Size(max = 45)
    @Column(name = "species", length = 45)
    private String species;

    @Size(max = 255)
    @Column(name = "strain")
    private String strain;

    @Size(max = 45)
    @Column(name = "assay_result", length = 45)
    private String assayResult;

    @Column(name = "year")
    private Integer year;

    @Column(name = "rn")
    private Long rn;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}