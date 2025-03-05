package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.toxrefdata.ToxRefDataAll;
import gov.epa.ccte.api.hazard.projection.toxrefdata.ToxRefDataProjection;
import gov.epa.ccte.api.hazard.projection.toxrefdata.ToxRefDataSummary;
import gov.epa.ccte.api.hazard.repository.ToxRefDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ToxRefDataResource implements ToxRefDataResourceApi {
    private final ToxRefDataRepository repository;

    public ToxRefDataResource(ToxRefDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<ToxRefDataAll> toxRefDataByStudyId(Integer studyId) {
        log.debug("all Tox Ref Data by Study ID = {}", studyId);

        List<ToxRefDataAll> data = repository.findAllByStudyId(studyId, ToxRefDataAll.class);

        return data;
    }


    @Override
    public @ResponseBody
    List<ToxRefDataAll> toxRefDataByDtxsid(String dtxsid) {
        log.debug("all Tox Ref Data by DTXSID = {}", dtxsid);

        List<ToxRefDataAll> data = repository.findAllByDtxsid(dtxsid, ToxRefDataAll.class);

        return data;
    }    


    @Override
    public @ResponseBody
    List<ToxRefDataAll> toxRefDataByStudyType(String studyType) {
        log.debug("all Tox Ref Data by Study Type = {}", studyType);

        List<ToxRefDataAll> data = repository.findAllByStudyType(studyType, ToxRefDataAll.class);

        return data;
    }
}
