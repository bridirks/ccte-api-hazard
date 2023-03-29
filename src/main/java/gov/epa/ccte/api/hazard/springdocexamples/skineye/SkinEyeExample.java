package gov.epa.ccte.api.hazard.springdocexamples.skineye;

import lombok.Data;
import java.util.List;

/**
 * POJO that is used by jackson to map resources/examples/skineye/*.json files.
 */
@Data
public class SkinEyeExample {
    private String description;
    private String summary;
    private String identifier;
    private List<SkinEyeDtoExample> results;
}
