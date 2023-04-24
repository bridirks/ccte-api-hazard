package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.CancerSummaryAll;
import gov.epa.ccte.api.hazard.repository.CancerSummaryRepository;
import gov.epa.ccte.api.hazard.web.rest.error.RequestWithHigherNumberOfDtxsidProblem;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;

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
    @Value("${application.batch-size}")
    private Integer batchSize;

    public CancerSummaryResource(CancerSummaryRepository repository) {
        this.repository = repository;
    }


    /**
     * {@code GET  hazard/cancer-summary/search/by-dtxsid/{dtxsid} : get list of cancer summary data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the cancer summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of cancer summary}.
     */
    @Operation(summary = "Get data by dtxsid")
    @GetMapping(value = "hazard/cancer-summary/search/by-dtxsid/{dtxsid}")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CancerSummaryAll.class})))
    })
    public @ResponseBody
    List<CancerSummaryAll> cancerSummaryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<CancerSummaryAll> data = repository.findAllByDtxsid(dtxsid, CancerSummaryAll.class);

        return data;
    }

    /**
     * {@code POST  hazard/cancer-summary/search/by-dtxsid/ : get list of cancer summary data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the cancer summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of cancer summary}.
     */
    @Operation(summary = "Get data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "Successfull",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CancerSummaryAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject(name = "", value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {Problem.class})))
    })
    @PostMapping(value = "hazard/cancer-summary/search/by-dtxsid/")
    public @ResponseBody
    List<CancerSummaryAll> cancerSummaryBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                               @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new RequestWithHigherNumberOfDtxsidProblem(dtxsids.length);

        List<CancerSummaryAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, CancerSummaryAll.class);

        return data;
    }

}
