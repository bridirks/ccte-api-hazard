package gov.epa.ccte.api.hazard.springdocexamples.skineye;

import lombok.Data;
import java.util.List;
@Data
public class SkinEyeExample {
    private String description;
    private String summary;
    private String identifier;
    private List<SkinEyeDtoExample> results;
}
