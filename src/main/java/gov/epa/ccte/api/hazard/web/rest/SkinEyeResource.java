package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.SkinEyeAll;
import gov.epa.ccte.api.hazard.repository.SkinEyeRepository;
import gov.epa.ccte.api.hazard.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class SkinEyeResource implements SkinEyeResourceApi {

    private final SkinEyeRepository repository;
    @Value("${application.batch-size}")
    private Integer batchSize;

    public SkinEyeResource(SkinEyeRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<SkinEyeAll> skinEyedByDtxsid(String dtxsid) {
        log.debug("all skin eye for dtxsid = {}", dtxsid);

        List<SkinEyeAll> data = repository.findAllByDtxsid(dtxsid, SkinEyeAll.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<SkinEyeAll> skinEyedBatch( String[] dtxsids) {
        log.debug("all skin eye for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<SkinEyeAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, SkinEyeAll.class);

        return data;
    }
}
