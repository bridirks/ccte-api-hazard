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
    private final Integer id;
    @Size(max = 255)
    private final String cancerCall;
    @Size(max = 255)
    private final String dtxsid;
    @Size(max = 255)
    private final String exposureRoute;
    private final Long rn;
    @Size(max = 255)
    private final String source;
    @Size(max = 255)
    private final String url;
}
