package gov.epa.ccte.api.hazard.domain;

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
@Entity
@Table(name = "genetox_summary", schema = "ms")
public class GenetoxSummary {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "dtxsid")
    private String dtxsid;

    @Column(name = "reports_pos")
    private Integer reportsPositive;

    @Column(name = "reports_neg")
    private Integer reportsNegative;

    @Column(name = "reports_other")
    private Integer reportsOther;

    @Size(max = 255)
    @Column(name = "ames")
    private String ames;

    @Size(max = 255)
    @Column(name = "micronucleus")
    private String micronucleus;

    @Column(name = "rn")
    private Long rn;


}