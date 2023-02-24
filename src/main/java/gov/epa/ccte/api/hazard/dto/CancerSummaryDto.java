package gov.epa.ccte.api.hazard.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.CancerSummary} entity
 */

@Data
public class CancerSummaryDto {
    @NotNull
    private Integer id;

    @Size(max = 255)
    private String cancerCall;

    @Size(max = 255)
    private String dtxsid;

    @Size(max = 255)
    private String exposureRoute;

    private Long rn;

    @Size(max = 255)
    private String source;

    @Size(max = 255)
    private String url;
}
