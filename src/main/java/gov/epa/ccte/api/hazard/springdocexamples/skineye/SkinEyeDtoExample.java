package gov.epa.ccte.api.hazard.springdocexamples.skineye;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.hazard.dto.SkinEyeDto;
public class SkinEyeDtoExample extends SkinEyeDto {
    @JsonCreator
    public SkinEyeDtoExample(@JsonProperty("id") Integer id, @JsonProperty("classification") String classification, @JsonProperty("dtxsid") String dtxsid, @JsonProperty("endpoint") String endpoint, @JsonProperty("guideline") String guideline, @JsonProperty("reliability") String reliability, @JsonProperty("resultText") String resultText, @JsonProperty("rn") Long rn, @JsonProperty("score") String score, @JsonProperty("source") String source, @JsonProperty("species") String species, @JsonProperty("strain") String strain, @JsonProperty("studyType") String studyType, @JsonProperty("year") Integer year) {
        super(id, classification, dtxsid, endpoint, guideline, reliability, resultText, rn, score, source, species, strain, studyType, year);
    }
}
