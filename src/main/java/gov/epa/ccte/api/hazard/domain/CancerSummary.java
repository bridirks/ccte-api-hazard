package gov.epa.ccte.api.hazard.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "cancer_summary")
public class CancerSummary {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "cancer_call")
    private String cancerCall;

    @Size(max = 255)
    private String dtxsid;

    @Size(max = 255)
    @Column(name = "exposure_route")
    private String exposureRoute;

    private Long rn;

    @Size(max = 255)
    private String source;

    @Size(max = 255)
    private String url;

}
