package gov.epa.ccte.api.hazard.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.hazard.domain.HAWC;
import gov.epa.ccte.api.hazard.repository.HAWCRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class HAWCResource implements HAWCApi{

    private final HAWCRepository repository;
    
    public HAWCResource(HAWCRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<HAWC> hawcDataByDtxsid(String dtxsid) {
        log.debug("CCD - EPA HAWC link mapper for dtxsid = {}", dtxsid);
        
        List<HAWC> data = repository.findByDtxsid(dtxsid);
        
        return data;
    }
}
