package gov.epa.ccte.api.hazard.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.hazard.domain.PPRTVChemicals;
import gov.epa.ccte.api.hazard.repository.PPRTVChemicalsRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class PPRTVChemicalsResource implements PPRTVChemicalsApi{

    private final PPRTVChemicalsRepository repository;
    
    public PPRTVChemicalsResource(PPRTVChemicalsRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public @ResponseBody
    List<PPRTVChemicals> pprtvChemicalsByDtxsid(String dtxsid) {
        log.debug("all PPRTV Chemical data = {}", dtxsid);

        List<PPRTVChemicals> data = repository.findAllByDtxsid(dtxsid);

        return data;
    }
}
