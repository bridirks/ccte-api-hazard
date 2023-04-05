package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.EcotoxAll;
import gov.epa.ccte.api.hazard.repository.EcotoxRepository;
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
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Ecotox}s.
 */
@Tag(name = "Ecotox Resource",
        description = "API endpoints for collecting ecotox data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class EcotoxResource {

    private final EcotoxRepository repository;

    public EcotoxResource(EcotoxRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  ecotox/search/by-dtxsid/{dtxsid} : get list of ecotox data for the "dtxsid".
     * @param dtxsid the matching dtxsid of the ecotox data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of ecotox}.
     */
    @Operation(summary = "Get ecotox data by dtxsid")
    @GetMapping(value = "/ecotox/search/by-dtxsid/{dtxsid}")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {EcotoxAll.class})))
    })
    public @ResponseBody
    List<EcotoxAll> ecotoxdByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all ecotox for dtxsid = {}", dtxsid);

        List<EcotoxAll> data = repository.findAllByDtxsid(dtxsid, EcotoxAll.class);

        return data;
    }

    /**
     * {@code POST  /ecotox/search/by-dtxsid/ : get list of ecotox  data for batch "dtxsid".
     * @param dtxsid the matching dtxsid of the ecotox data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of ecotox}.
     */
    @Operation(summary = "Get ecotox data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {EcotoxAll.class})))
    })
    @PostMapping(value = "/ecotox/search/by-dtxsid/")
    public @ResponseBody
    List<EcotoxAll> ecotoxdBBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                           @RequestBody String[] dtxsids) {

        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        List<EcotoxAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, EcotoxAll.class);

        return data;
    }
}
