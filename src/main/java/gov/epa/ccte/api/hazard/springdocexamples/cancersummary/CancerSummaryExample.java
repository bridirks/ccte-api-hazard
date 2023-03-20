package gov.epa.ccte.api.hazard.springdocexamples.cancersummary;

import lombok.Data;
import java.util.List;

@Data
public class CancerSummaryExample {
    private String description;
    private String summary;
    private String identifier;
    private List<CancerSummaryDtoExample> results;
}
