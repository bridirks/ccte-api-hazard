package gov.epa.ccte.api.hazard.springdocexamples.cancersummary;

import lombok.Data;
import java.util.List;

/**
 * POJO that is used by jackson to map resources/examples/cancersummary/*.json files.
 */
@Data
public class CancerSummaryExample {
    private String description;
    private String summary;
    private String identifier;
    private List<CancerSummaryDtoExample> results;
}
