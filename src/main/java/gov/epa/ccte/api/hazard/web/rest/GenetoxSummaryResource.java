package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.GenetoxSummary;
import gov.epa.ccte.api.hazard.repository.GenetoxSummaryRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.GenetoxDetail}s.
 */

@Tag(name = "Genetox Summary Resource",
        description = "API endpoints for collecting Geneto summary data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class GenetoxSummaryResource {

    private final GenetoxSummaryRepository repository;

    public GenetoxSummaryResource(GenetoxSummaryRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  hazard/genetox-summary/search/by-dtxsid/{dtxsid} : get list of genetox summary data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox summary}.
     */
    @Operation(summary = "Get genetox summary data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxSummary.class})))
    })
    @GetMapping(value = "hazard/genetox-summary/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<GenetoxSummary> genetoxSummaryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxSummary> data = repository.findByDtxsid(dtxsid, GenetoxSummary.class);

        return data;
    }

    /**
     * {@code POST  hazard/genetox-summary/search/by-dtxsid/{dtxsid} : get list of genetox summary data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox summary}.
     */
    @Operation(summary = "Get Genetox Summary data by batch of dtxsid(s).")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxSummary.class})))
    })
    @PostMapping(value = "hazard/genetox-summary/search/by-dtxsid/")
    public @ResponseBody
    List<GenetoxSummary>batchSearch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                   @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        List<GenetoxSummary> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxSummary.class);

        return data;
    }
}
