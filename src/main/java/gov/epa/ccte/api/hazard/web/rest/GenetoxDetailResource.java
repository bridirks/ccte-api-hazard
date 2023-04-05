package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.GenetoxDetailAll;
import gov.epa.ccte.api.hazard.repository.GenetoxDetailRepository;
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

@Tag(name = "Genetox Detail Resource",
        description = "API endpoints for collecting Genetox details data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class GenetoxDetailResource {

    private final GenetoxDetailRepository repository;

    public GenetoxDetailResource(GenetoxDetailRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  hazard/genetox-details/search/by-dtxsid/{dtxsid} : get list of genetox detail data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox detail data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox detail}.
     */
    @Operation(summary = "Get genetox detail data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxDetailAll.class})))
    })
    @GetMapping(value = "hazard/genetox-details/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<GenetoxDetailAll>genetoxDetailsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxDetailAll> data = repository.findByDtxsidOrderBySourceAsc(dtxsid, GenetoxDetailAll.class);

        return data;
    }


    /**
     * {@code POST  hazard/genetox-details/search/by-dtxsid/{dtxsid} : get list of genetox detail data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the genetox detail data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of genetox detail}.
     */
    @Operation(summary = "Get genetox detail data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {GenetoxDetailAll.class})))
    })
    @PostMapping(value = "hazard/genetox-details/search/by-dtxsid/")
    public @ResponseBody
    List<GenetoxDetailAll>batchSearch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                   @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size= {}", dtxsids.length);

        List<GenetoxDetailAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxDetailAll.class);

        return data;
    }
}
