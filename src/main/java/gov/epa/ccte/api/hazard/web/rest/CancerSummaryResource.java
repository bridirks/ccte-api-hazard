package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.CancerSummary;
import gov.epa.ccte.api.hazard.repository.CancerSummaryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.CancerSummary}s.
 */

@Tag(name = "Cancer Summary Resource",
        description = "API endpoints for collecting cancer summary data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class CancerSummaryResource {

    private final CancerSummaryRepository repository;

    public CancerSummaryResource(CancerSummaryRepository repository) {
        this.repository = repository;
    }


    /**
     * {@code GET  hazard/cancer-summary/search/by-dtxsid/{dtxsid} : get list of cancer summary data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the cancer summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of cancer summary}.
     */
    @Operation(summary = "Get cancer summary data by dtxsid")
    @GetMapping(value = "hazard/cancer-summary/search/by-dtxsid/{dtxsid}")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CancerSummary.class})))
    })
    public @ResponseBody
    List<CancerSummary> cancerSummaryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<CancerSummary> data = repository.findAllByDtxsid(dtxsid, CancerSummary.class);

        return data;
    }

    /**
     * {@code POST  hazard/cancer-summary/search/by-dtxsid/ : get list of cancer summary data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the cancer summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of cancer summary}.
     */
    @Operation(summary = "Get cancer summary data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CancerSummary.class})))
    })
    @PostMapping(value = "hazard/cancer-summary/search/by-dtxsid/")
    public @ResponseBody
    List<CancerSummary> cancerSummaryBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                               @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        List<CancerSummary> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, CancerSummary.class);

        return data;
    }

}
