package gov.epa.ccte.api.hazard.springdocexamples.ecotox;

import lombok.Data;
import java.util.List;
@Data
public class EcotoxExample {
    private String description;
    private String summary;
    private String identifier;
    private List<EcotoxDtoExample> results;
}
