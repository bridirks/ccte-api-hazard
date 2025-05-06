package gov.epa.ccte.api.hazard.web.rest.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *  Create since I couldn't throw Problem from authentication filter.
 *  It is normal JSON object following Problem structure.
 */

@Getter
@Setter
@Builder
public class AuthorizationProblem {

    private String title;
    private String detail;
}
