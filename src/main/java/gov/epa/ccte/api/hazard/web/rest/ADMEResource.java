package gov.epa.ccte.api.hazard.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.hazard.domain.ADME;
import gov.epa.ccte.api.hazard.repository.ADMERepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ADMEResource implements ADMEApi{
    private final ADMERepository repository;
    
    public ADMEResource(ADMERepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<?> admeDataByDtxsid(String dtxsid, String projection) {
        log.debug("all ADME - IVIVE data = {}", dtxsid);

        if (projection == null || projection.isEmpty()) {
            List<ADME> result = repository.findByDtxsid(dtxsid, ADME.class);
            return result != null ? List.of(result) : List.of(); 
        }

        Object result = switch (projection) {
        	case "ccd-adme-data" -> repository.findByDtxsidWithLabelColumn(dtxsid);
        	default -> repository.findByDtxsid(dtxsid, ADME.class);
        };

        if (result instanceof List<?>) {
            return (List<?>) result;
        } else if (result != null) {
            return List.of(result); 
        } else {
            return List.of(); 
        }
    }

}
