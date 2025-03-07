package gov.epa.ccte.api.hazard.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link gov.epa.ccte.api.hazard.domain.SkinEye} entity
 */
@Data
public class SkinEyeDto {
	
    @NotNull
    private final Integer id;
    @Size(max = 45)
    private final String authority;
    @Size(max = 255)
    private final String classification;
    @Size(max = 255)
    private final String dtxsid;
    @Size(max = 255)
    private final String endpoint;
    private final String glp;
    private final String guideline;
    @Size(max = 1024)
    private final String recordUrl;
    @Size(max = 45)
    private final String reliability;
    @Size(max = 1024)
    private final String resultText;
    @Size(max = 45)
    private final String score;
    @Size(max = 255)
    private final String skinEyeHash;
    private final Integer skinEyeId;
    @Size(max = 255)
    private final String skinEyeUuid;
    @Size(max = 45)
    private final String source;
    @Size(max = 255)
    private final String species;
    @Size(max = 255)
    private final String strain;
    @Size(max = 255)
    private final String studyType;
    private final Integer year;
}
