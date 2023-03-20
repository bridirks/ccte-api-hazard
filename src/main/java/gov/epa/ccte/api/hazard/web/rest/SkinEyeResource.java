package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.SkinEye;
import gov.epa.ccte.api.hazard.dto.SkinEyeDto;
import gov.epa.ccte.api.hazard.dto.mapper.SkinEyeMapper;
import gov.epa.ccte.api.hazard.repository.SkinEyeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.SkinEye}s.
 */
@Tag(name = "Skin Eye Resource",
        description = "API endpoints for collecting skin eye data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin
public class SkinEyeResource {

    private final SkinEyeRepository repository;

    private final SkinEyeMapper mapper;

    public SkinEyeResource(SkinEyeRepository repository, SkinEyeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@code GET  hazard/skin-eye/search/by-dtxsid/{dtxsid} : get list of skin eye data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the skin eye data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of skin eye}.
     */
    @Operation(summary = "Get skin eye (both human and eco) data by dtxsid")
    @GetMapping(value = "/hazard/skin-eye/search/by-dtxsid/{dtxsid}")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(examples =
                    {
                            @ExampleObject(name = "200-found-skineye", ref = "#/components/examples/hazard-search-skineye-by-dtxsid-DTXSID0021125"),
                            @ExampleObject(name = "200-hazard-skineye-search-not-found", ref = "#/components/examples/empty-result-set"),
                    }))
    })
    public @ResponseBody
    List<SkinEyeDto> skinEyedByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all skin eye for dtxsid = {}", dtxsid);

        List<SkinEye> data = repository.findAllByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
