package gov.epa.ccte.api.hazard.springdocexamples.hazard;

import lombok.Data;

import java.util.List;

@Data
public class HazardExample {
    private String description;
    private String summary;
    private String identifier;
    private List<HazardDtoExample> results;
}
