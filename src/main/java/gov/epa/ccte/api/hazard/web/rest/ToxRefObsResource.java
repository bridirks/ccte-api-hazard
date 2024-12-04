package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.ToxRefObsAll;
import gov.epa.ccte.api.hazard.repository.ToxRefObsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ToxRefObsResource implements ToxRefObsResourceApi {
    private final ToxRefObsRepository repository;

    public ToxRefObsResource(ToxRefObsRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<ToxRefObsAll> toxRefObsByStudyId(Integer studyId) {
        log.debug("all Tox Ref Observations by Study ID = {}", studyId);

        List<ToxRefObsAll> data = repository.findAllByStudyId(studyId, ToxRefObsAll.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<ToxRefObsAll> toxRefObsByDtxsid( String dtxsid) {
        log.debug("all Tox Ref Observations by DTXSID  = {}", dtxsid);

        List<ToxRefObsAll> data = repository.findAllByDtxsid(dtxsid, ToxRefObsAll.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<ToxRefObsAll> toxRefObsByStudyType( String studyType) {
        log.debug("all Tox Ref Observations by Study Type = {}", studyType);

        List<ToxRefObsAll> data = repository.findAllByStudyType(studyType, ToxRefObsAll.class);
        log.debug("data size = {}", data.size());

        return data;
    }
}
