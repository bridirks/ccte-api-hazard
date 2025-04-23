package gov.epa.ccte.api.hazard.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.hazard.domain.IRIS;
import gov.epa.ccte.api.hazard.repository.IRISRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class IRISResource implements IRISApi{

    private final IRISRepository repository;
    
    public IRISResource(IRISRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<IRIS> irisDataByDtxsid(String dtxsid) {
        log.debug("all IRIS data = {}", dtxsid);
        
        List<IRIS> data = repository.findByDtxsid(dtxsid);
        
        return data;
    }
    
}
