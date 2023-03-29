package gov.epa.ccte.api.hazard.springdocexamples.cancersummary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.hazard.dto.CancerSummaryDto;

/**
 * Used by jackson for serialization purposes.
 */
public class CancerSummaryDtoExample extends CancerSummaryDto {

    // Jackson uses this constructor to convert json objects.
    @JsonCreator
    public CancerSummaryDtoExample(@JsonProperty("id") Integer id, @JsonProperty("cancerCall") String cancerCall, @JsonProperty("dtxsid") String dtxsid, @JsonProperty("exposureRoute") String exposureRoute, @JsonProperty("rn") Long rn, @JsonProperty("source") String source, @JsonProperty("url") String url) {
        super(id, cancerCall, dtxsid, exposureRoute, rn, source, url);
    }
}
