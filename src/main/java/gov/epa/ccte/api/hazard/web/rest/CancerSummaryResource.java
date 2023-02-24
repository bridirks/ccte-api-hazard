package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.CancerSummary;
import gov.epa.ccte.api.hazard.domain.Ecotox;
import gov.epa.ccte.api.hazard.dto.CancerSummaryDto;
import gov.epa.ccte.api.hazard.dto.EcotoxDto;
import gov.epa.ccte.api.hazard.dto.mapper.CancerSummaryMapper;
import gov.epa.ccte.api.hazard.dto.mapper.EcotoxMapper;
import gov.epa.ccte.api.hazard.repository.CancerSummaryRepository;
import gov.epa.ccte.api.hazard.repository.EcotoxRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.CancerSummary}s.
 */

@Tag(name = "Cancer Summary Resource",
        description = "API endpoints for collecting cancer summary data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin
public class CancerSummaryResource {

    private final CancerSummaryRepository repository;
    private final CancerSummaryMapper mapper;

    public CancerSummaryResource(CancerSummaryRepository repository, CancerSummaryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    /**
     * {@code GET  hazard/cancer-summary/search/by-dtxsid/{dtxsid} : get list of cancer summary data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the cancer summary data to retrieve.
     * @return the {@link ResponseEntity } with status {@code 200 (OK)} and with body the list of cancer summary}.
     */
    @Operation(summary = "Get cancer summary (both human and eco) data by dtxsid")
    @GetMapping(value = "hazard/cancer-summary/search/by-dtxsid/{dtxsid}")
    public @ResponseBody
    List<CancerSummaryDto> cancerSummaryByDtxsid(@PathVariable("dtxsid") String dtxsid) {

        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<CancerSummary> data = repository.findAllByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
