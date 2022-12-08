package gov.epa.ccte.api.hazard.web.rest;


import gov.epa.ccte.api.hazard.domain.Hazard;
import gov.epa.ccte.api.hazard.repository.HazardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.hazard.domain.Hazard}s.
 */
@Slf4j
@RestController
public class HazardResource {

    final private HazardRepository repository;

    public HazardResource(HazardRepository repository) {
        this.repository = repository;
    }

    /**
     * {@code GET  /hazard/by-dtxsid/{dtxsid} : get list of hazard data for the "dtxsid".
     *
     * @param dtxsid the matching dtxsid of the hazard data to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of hazard}.
     */
    @RequestMapping(value = "hazard/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET)
    public @ResponseBody
    List<Hazard> hazardByDtxsid(@PathVariable("dtxsid") String dtxsid) throws IOException {

        log.debug("dtxsid = {}", dtxsid);

        return repository.findByDtxsid(dtxsid);
    }
}
