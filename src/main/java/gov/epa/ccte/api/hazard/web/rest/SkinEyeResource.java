package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.SkinEyeAll;
import gov.epa.ccte.api.hazard.repository.SkinEyeRepository;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.SkinEye}s.
 */
@Tag(name = "Skin Eye Resource",
        description = "API endpoints for collecting skin eye data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class SkinEyeResource {

    private final SkinEyeRepository repository;

    public SkinEyeResource(SkinEyeRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  hazard/skin-eye/search/by-dtxsid/{dtxsid} : get list of skin eye data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the skin eye data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of skin eye}.
     */
    @Operation(summary = "Get data by dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {SkinEyeAll.class})))
    })
    @GetMapping(value = "/hazard/skin-eye/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<SkinEyeAll> skinEyedByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all skin eye for dtxsid = {}", dtxsid);

        List<SkinEyeAll> data = repository.findAllByDtxsid(dtxsid, SkinEyeAll.class);

        return data;
    }

    /**
     * {@code POST  hazard/skin-eye/search/by-dtxsid/{dtxsid} : get list of skin eye data for batch "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the skin eye data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of skin eye}.
     */
    @Operation(summary = "Get data by batch of dtxsid(s)")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {SkinEyeAll.class})))
    })
    @PostMapping(value = "/hazard/skin-eye/search/by-dtxsid/")
    public @ResponseBody
    List<SkinEyeAll> skinEyedBatch(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                @RequestBody String[] dtxsids) {

        log.debug("all skin eye for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > 200)
            throw new RequestWithHigherNumberOfDtxsidProblem(dtxsids.length);

        List<SkinEyeAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, SkinEyeAll.class);

        return data;
    }
}
