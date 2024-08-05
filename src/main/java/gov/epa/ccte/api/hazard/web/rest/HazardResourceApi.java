package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.HazardAll;
import io.swagger.v3.oas.annotations.Hidden;
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
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Hazard}s.
 */
@Tag(name = "Hazard Resource",
        description = "API endpoints for collecting hazard data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
public interface HazardResourceApi {
    @Hidden
    @GetMapping("/hazard/health")
    ResponseEntity health();

    /**
     * {@code GET  hazard/search/by-dtxsid/{dtxsid} : get list of hazard data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get all data by dtxsid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    @ResponseBody
    List<HazardAll> hazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                   @PathVariable("dtxsid") String dtxsid);

    /**
     * {@code POST  hazard/search/by-dtxsid/ : get list of hazard data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get all data by batch of dtxsid(s).", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content(mediaType = "application/json",
                            examples = {@ExampleObject(value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                            schema = @Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/", method = RequestMethod.POST)
    @ResponseBody
    List<HazardAll> hazardBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                @RequestBody String[] dtxsids);

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid"
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get human data by dtxsid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    @ResponseBody
    List<HazardAll> humanHazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                        @PathVariable("dtxsid") String dtxsid);

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get human data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content(mediaType = "application/json",
                            examples = {@ExampleObject(value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                            schema = @Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/", method = RequestMethod.POST)
    @ResponseBody
    List<HazardAll> humanBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                               @RequestBody String[] dtxsids);

    /**
     * {@code GET  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid"
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get eco data by dtxsid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    @ResponseBody
    List<HazardAll> ecoHazardByDtxsid(
            @Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
            @PathVariable("dtxsid") String dtxsid);

    /**
     * {@code POST  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for batch "dtxsid".
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get eco data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content(mediaType = "application/json",
                            examples = {@ExampleObject(value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                            schema = @Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/", method = RequestMethod.POST)
    @ResponseBody
    List<HazardAll> ecoBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                             @RequestBody String[] dtxsids);
}
