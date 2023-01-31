package gov.epa.ccte.api.hazard.web.rest;


import gov.epa.ccte.api.hazard.domain.Hazard;
import gov.epa.ccte.api.hazard.dto.HazardDto;
import gov.epa.ccte.api.hazard.dto.mapper.HazardMapper;
import gov.epa.ccte.api.hazard.repository.HazardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Hazard}s.
 */
@Tag(name = "Hazard Resource",
        description = "API endpoints for collecting hazard data for specified chemical identifier (DTXSID).")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
@CrossOrigin
public class HazardResource {

    final private HazardRepository repository;
    final private HazardMapper mapper;
    public HazardResource(HazardRepository repository, HazardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * {@code GET  hazard/search/by-dtxsid/{dtxsid} : get list of hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get hazard (both human and eco) data by dtxsid")
    @RequestMapping(value = "hazard/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardDto> hazardByDtxsid(@PathVariable("dtxsid") String dtxsid) throws IOException {

        log.debug("all hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findAllByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * {@code GET  hazard/search/human/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get human hazard data by dtxsid")
    @RequestMapping(value = "hazard/human/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardDto> humanHazardByDtxsid(@PathVariable("dtxsid") String dtxsid) throws IOException {

        log.debug("human hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findHumanDataByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * {@code GET  hazard/search/eco/by-dtxsid/{dtxsid} : get list of human hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the human hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @Operation(summary = "Get Ecotox data by dtxsid")
    @RequestMapping(value = "hazard/eco/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<HazardDto> ecoHazardByDtxsid(@PathVariable("dtxsid") String dtxsid) throws IOException {

        log.debug("eco hazard for dtxsid = {}", dtxsid);

        List<Hazard> data = repository.findEcoDataByDtxsid(dtxsid);

        return data.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
