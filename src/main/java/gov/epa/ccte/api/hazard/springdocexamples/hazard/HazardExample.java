package gov.epa.ccte.api.hazard.springdocexamples.hazard;

import lombok.Data;

import java.util.List;

/**
 * POJO that is used by jackson to map resources/examples/hazard/*.json files.
 */
@Data
public class HazardExample {
    private String description;
    private String summary;
    private String identifier;
    private List<HazardDtoExample> results;
}
