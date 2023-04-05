package gov.epa.ccte.api.hazard.web.rest;


import gov.epa.ccte.api.hazard.projection.Hazard;
import gov.epa.ccte.api.hazard.repository.HazardRepository;
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

    public HazardResource(HazardRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  hazard/search/by-dtxsid/{dtxsid} : get list of hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard (both human and eco) data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<Hazard> hazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                   @PathVariable("dtxsid") String dtxsid)  {

        log.debug("all hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findAllByDtxsid(new String[]{dtxsid}, Hazard.class);

        return data;
    }

    /**
     * {@code POST  hazard/search/by-dtxsid/ : get list of hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard (human and eco) data by batch of dtxsid(s).")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<Hazard> hazardBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                             @RequestBody String[] dtxsids) {

        log.debug("all hazard for dtxsid size = {}", dtxsids.length);

        List<Hazard> data = repository.findAllByDtxsid(dtxsids, Hazard.class);

        return data;
    }

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard human data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<Hazard> humanHazardByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                        @PathVariable("dtxsid") String dtxsid) {

        log.debug("human hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findHumanDataByDtxsid(new String[]{dtxsid}, Hazard.class);

        return data;
    }

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard human data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/human/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<Hazard> humanBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                     @RequestBody String[] dtxsids) {

        log.debug("human hazard for dtxsid size = {}", dtxsids.length);

        List<Hazard> data = repository.findHumanDataByDtxsid(dtxsids, Hazard.class);

        return data;
    }

    /**
     * {@code GET  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard eco data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<Hazard> ecoHazardByDtxsid(
            @Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125")
                                      @PathVariable("dtxsid") String dtxsid) {

        log.debug("eco hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findEcoDataByDtxsid(new String[]{dtxsid}, Hazard.class);

        return data;
    }

    /**
     * {@code POST  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get Hazard eco data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {Hazard.class})))
    })
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/", method = RequestMethod.POST)
    public @ResponseBody
    List<Hazard> ecoBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                          @RequestBody String[] dtxsids){

        log.debug("eco hazard for dtxsid size = {}", dtxsids.length);

        List<Hazard> data = repository.findEcoDataByDtxsid(dtxsids, Hazard.class);

        return data;
    }
}
