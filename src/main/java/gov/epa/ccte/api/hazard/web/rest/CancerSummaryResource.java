package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.CancerSummaryAll;
import gov.epa.ccte.api.hazard.repository.CancerSummaryRepository;
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
public class CancerSummaryResource implements CancerSummaryResourceApi {
    private final CancerSummaryRepository repository;

    @Value("${application.batch-size}")
    private Integer batchSize;

    public CancerSummaryResource(CancerSummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<CancerSummaryAll> cancerSummaryByDtxsid(String dtxsid) {
        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<CancerSummaryAll> data = repository.findAllByDtxsid(dtxsid, CancerSummaryAll.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<CancerSummaryAll> cancerSummaryBatch(String[] dtxsids) {
        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<CancerSummaryAll> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, CancerSummaryAll.class);

        return data;
    }

}
