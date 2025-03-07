package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.GenetoxDetailAll;
import gov.epa.ccte.api.hazard.projection.GenetoxSummaryAll;
import gov.epa.ccte.api.hazard.repository.GenetoxDetailRepository;
import gov.epa.ccte.api.hazard.repository.GenetoxSummaryRepository;
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
public class GenetoxResource implements GenetoxApi {
    private final GenetoxDetailRepository detailRepository;
    private final GenetoxSummaryRepository summaryRepository;

    @Value("${application.batch-size}")
    private Integer batchSize;

    public GenetoxResource(GenetoxDetailRepository repository, GenetoxSummaryRepository summaryRepository) {
        this.detailRepository = repository;
        this.summaryRepository = summaryRepository;
    }

// *********************** Summary - start *************************************

    @Override
    public @ResponseBody
    List<GenetoxSummaryAll> genetoxSummaryByDtxsid(String dtxsid) {
        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxSummaryAll> data = summaryRepository.findByDtxsid(dtxsid, GenetoxSummaryAll.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<GenetoxSummaryAll>batchSearchSummary(String[] dtxsids) {
        log.debug("all cancer summary for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<GenetoxSummaryAll> data = summaryRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxSummaryAll.class);

        return data;
    }

// *********************** Summary - End *************************************

// *********************** Detail - start *************************************

    @Override
    public @ResponseBody
    List<GenetoxDetailAll> genetoxDetailsByDtxsid(String dtxsid) {
        log.debug("all cancer summary for dtxsid = {}", dtxsid);

        List<GenetoxDetailAll> data = detailRepository.findByDtxsidOrderBySourceAsc(dtxsid, GenetoxDetailAll.class);

        return data;
    }


    @Override
    public @ResponseBody
    List<GenetoxDetailAll> batchSearch(String[] dtxsids) {
        log.debug("all cancer summary for dtxsid size= {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<GenetoxDetailAll> data = detailRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenetoxDetailAll.class);

        return data;
    }
}
