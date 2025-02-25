package gov.epa.ccte.api.hazard.web.rest;


import gov.epa.ccte.api.hazard.projection.HazardAll;
import gov.epa.ccte.api.hazard.repository.HazardRepository;
import gov.epa.ccte.api.hazard.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class HazardResource implements HazardApi {
    final private HazardRepository repository;
    private final JdbcTemplate jdbcTemplate;

    @Value("${application.batch-size}")
    private Integer batchSize;

    public HazardResource(HazardRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ResponseEntity health(){

        log.info("checking the health");

        if(jdbcTemplate != null){
            try {
                jdbcTemplate.execute("SELECT 1 ");
                log.debug("DB connection established");

                return ResponseEntity.ok().build();

            } catch (Exception ep){
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public @ResponseBody
    List<HazardAll> hazardByDtxsid(String dtxsid) {
        log.debug("all hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findAllByDtxsid(new String[]{dtxsid}, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }

    @Override
    public @ResponseBody
    List<HazardAll> hazardBatch(String[] dtxsids) {

        log.debug("all hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findAllByDtxsid(dtxsids, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }

    @Override
    public @ResponseBody
    List<HazardAll> humanHazardByDtxsid(String dtxsid) {
        log.debug("human hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findHumanDataByDtxsid(new String[]{dtxsid}, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }

    @Override
    public @ResponseBody
    List<HazardAll> humanBatch(String[] dtxsids) {
        log.debug("human hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findHumanDataByDtxsid(dtxsids, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }

    @Override
    public @ResponseBody
    List<HazardAll> ecoHazardByDtxsid(String dtxsid) {
        log.debug("eco hazard for dtxsid = {}", dtxsid);

        List<HazardAll> data = repository.findEcoDataByDtxsid(new String[]{dtxsid}, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }

    @Override
    public @ResponseBody
    List<HazardAll> ecoBatch( String[] dtxsids){
        log.debug("eco hazard for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HazardAll> data = repository.findEcoDataByDtxsid(dtxsids, HazardAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }
}
