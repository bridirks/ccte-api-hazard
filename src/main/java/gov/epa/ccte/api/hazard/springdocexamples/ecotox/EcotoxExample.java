package gov.epa.ccte.api.hazard.springdocexamples.ecotox;

import lombok.Data;
import java.util.List;

/**
 * POJO that is used by jackson to map resources/examples/ecotox/*.json files.
 */
@Data
public class EcotoxExample {
    private String description;
    private String summary;
    private String identifier;
    private List<EcotoxDtoExample> results;
}
