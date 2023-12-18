package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.GenetoxDetailAll;
import gov.epa.ccte.api.hazard.projection.GenetoxSummaryAll;
import gov.epa.ccte.api.hazard.repository.GenetoxDetailRepository;
import gov.epa.ccte.api.hazard.repository.GenetoxSummaryRepository;
import gov.epa.ccte.api.hazard.web.rest.error.HigherNumberOfDtxsidException;
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
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.GenetoxDetail}s. and
 */

@Tag(name = "Genetox Resource",
        description = "API endpoints for collecting Genetox data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class GenetoxResource {

    private final GenetoxDetailRepository detailRepository;
    private final GenetoxSummaryRepository summaryRepository;
    @Value("${application.batch-size}")
    private Integer batchSize;

    public GenetoxResource(GenetoxDetailRepository repository, GenetoxSummaryRepository summaryRepository) {
        this.detailRepository = repository;
        this.summaryRepository = summaryRepository;
    }

// *********************** Summary - start *************************************

    /**
     * {@code GET  hazard/genetox/summary/search/by-dtxsid/{dtxsid} : get list of genetox summary data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox summary}.
     */
    @Operation(summary = "Get summary data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxSummaryAll.class})))
    })
    @GetMapping(value = "hazard/genetox/summary/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<GenetoxSummaryAll> genetoxSummaryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxSummaryAll> data = summaryRepository.findByDtxsid(dtxsid, GenetoxSummaryAll.class);

        return data;
    }

    /**
     * {@code POST  hazard/genetox/summary/search/by-dtxsid/{dtxsid} : get list of genetox summary data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox summary}.
     */
    @Operation(summary = "Get summary data by batch of dtxsid(s).", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxSummaryAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject(name = "", value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {ProblemDetail.class})))
    })
    @PostMapping(value = "hazard/genetox/summary/search/by-dtxsid/")
    public @ResponseBody
    List<GenetoxSummaryAll>batchSearchSummary(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                       @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<GenetoxSummaryAll> data = summaryRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxSummaryAll.class);

        return data;
    }

// *********************** Summary - End *************************************

// *********************** Detail - start *************************************

    /**
     * {@code GET  hazard/genetox-details/search/by-dtxsid/{dtxsid} : get list of genetox detail data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox detail data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox detail}.
     */
    @Operation(summary = "Get detail data by dtxsid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {GenetoxDetailAll.class})))
    })
    @GetMapping(value = "hazard/genetox/details/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<GenetoxDetailAll> genetoxDetailsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxDetailAll> data = detailRepository.findByDtxsidOrderBySourceAsc(dtxsid, GenetoxDetailAll.class);

        return data;
    }


    /**
     * {@code POST  hazard/genetox-details/search/by-dtxsid/{dtxsid} : get list of genetox detail data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox detail data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox detail}.
     */
    @Operation(summary = "Get detail data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {GenetoxDetailAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject(name = "", value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {ProblemDetail.class})))
    })
    @PostMapping(value = "hazard/genetox/details/search/by-dtxsid/")
    public @ResponseBody
    List<GenetoxDetailAll> batchSearch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                       @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size= {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<GenetoxDetailAll> data = detailRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxDetailAll.class);

        return data;
    }
}
