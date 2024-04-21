package gov.epa.ccte.api.hazard.web.rest;


import gov.epa.ccte.api.hazard.projection.HazardAll;
import gov.epa.ccte.api.hazard.repository.HazardRepository;
import gov.epa.ccte.api.hazard.web.rest.error.HigherNumberOfDtxsidException;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Hazard}s.
 */
@Tag(name = "Hazard Resource",
        description = "API endpoints for collecting hazard data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class HazardResource {
    final private HazardRepository repository;
    private final JdbcTemplate jdbcTemplate;

    @Value("${application.batch-size}")
    private Integer batchSize;

    public HazardResource(HazardRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Hidden
    @GetMapping("/hazard/health")
    public ResponseEntity health(){

        log.info("checking the health");

        if(jdbcTemplate != null){
            try {
                jdbcTemplate.execute("SELECT 1 ");
                log.debug("DB connection established");

                return ResponseEntity.ok().build();

            } catch (Exception ep){
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * {@code GET  hazard/search/by-dtxsid/{dtxsid} : get list of hazard data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get all data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardAll> hazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                   @PathVariable("dtxsid") String dtxsid)  {

        log.debug("all hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findAllByDtxsid(new String[]{dtxsid}, HazardAll.class);

        log.debug("data size = {}", data.size());
        return data;
    }

    /**
     * {@code POST  hazard/search/by-dtxsid/ : get list of hazard data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get all data by batch of dtxsid(s).", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject(value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<HazardAll> hazardBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                             @RequestBody String[] dtxsids) {

        log.debug("all hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findAllByDtxsid(dtxsids, HazardAll.class);

        log.debug("data size = {}", data.size());

        return data;
    }

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid"
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get human data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardAll> humanHazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                        @PathVariable("dtxsid") String dtxsid) {

        log.debug("human hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findHumanDataByDtxsid(new String[]{dtxsid}, HazardAll.class);

        log.debug("data size = {}", data.size());

        return data;
    }

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get human data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject( value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<HazardAll> humanBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                     @RequestBody String[] dtxsids) {

        log.debug("human hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findHumanDataByDtxsid(dtxsids, HazardAll.class);

        log.debug("data size = {}", data.size());

        return data;
    }

    /**
     * {@code GET  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid"
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get eco data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardAll> ecoHazardByDtxsid(
            @Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                      @PathVariable("dtxsid") String dtxsid) {

        log.debug("eco hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findEcoDataByDtxsid(new String[]{dtxsid}, HazardAll.class);

        log.debug("data size = {}", data.size());

        return data;
    }

    /**
     * {@code POST  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for batch "dtxsid".
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get eco data by batch of dtxsid(s)", description = "Note: Maximum ${application.batch-size} DTXSIDs per request")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HazardAll.class}))),
            @ApiResponse(responseCode = "400", description = "When user has submitted more then allowed number (${application.batch-size}) of DTXSID(s).",
                    content = @Content( mediaType = "application/json",
                    examples = {@ExampleObject(value = "{\"title\":\"Validation Error\",\"status\":400,\"detail\":\"System supports only '200' dtxsid at one time, '202' are submitted.\"}", description = "Validation error for more then allowed number of dtxsid(s).")},
                    schema=@Schema(oneOf = {ProblemDetail.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<HazardAll> ecoBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                          @RequestBody String[] dtxsids){

        log.debug("eco hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findEcoDataByDtxsid(dtxsids, HazardAll.class);

        log.debug("data size = {}", data.size());

        return data;
    }
}
