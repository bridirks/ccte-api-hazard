package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

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
    private Integer reportsPos;

    @Column(name = "reports_neg")
    private Integer reportsNeg;

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

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}