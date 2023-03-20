package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.Ecotox;
import gov.epa.ccte.api.hazard.dto.EcotoxDto;
import gov.epa.ccte.api.hazard.dto.mapper.EcotoxMapper;
import gov.epa.ccte.api.hazard.repository.EcotoxRepository;
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

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Ecotox}s.
 */
@Tag(name = "Ecotox Resource",
        description = "API endpoints for collecting ecotox data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin
public class EcotoxResource {

    private final EcotoxRepository repository;
    private final EcotoxMapper mapper;

    public EcotoxResource(EcotoxRepository repository, EcotoxMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@code GET  ecotox/search/by-dtxsid/{dtxsid} : get list of ecotox data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the ecotox data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of ecotox}.
     */
    @Operation(summary = "Get ecotox (both human and eco) data by dtxsid")
    @GetMapping(value = "/ecotox/search/by-dtxsid/{dtxsid}")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(examples =
                    {
                            @ExampleObject(name = "200-found-ecotox", ref = "#/components/examples/ecotox-search-by-dtxsid-DTXSID0021125"),
                            @ExampleObject(name = "200-ecotox-search-not-found", ref = "#/components/examples/empty-result-set"),
                    }))
    })
    public @ResponseBody
    List<EcotoxDto> ecotoxdByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0021125") @PathVariable("dtxsid") String dtxsid) {

        log.debug("all ecotox for dtxsid = {}", dtxsid);

        List<Ecotox> data = repository.findAllByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
