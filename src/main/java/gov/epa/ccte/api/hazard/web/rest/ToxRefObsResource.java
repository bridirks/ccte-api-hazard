package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.ToxRefObs;
import gov.epa.ccte.api.hazard.repository.ToxRefObsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ToxRefObsResource implements ToxRefObsApi {
    private final ToxRefObsRepository repository;

    public ToxRefObsResource(ToxRefObsRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<ToxRefObs> toxRefObsByStudyId(Integer studyId) {
        log.debug("all Tox Ref Observations by Study ID = {}", studyId);

        List<ToxRefObs> data = repository.findAllByStudyId(studyId, ToxRefObs.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<ToxRefObs> toxRefObsByDtxsid( String dtxsid) {
        log.debug("all Tox Ref Observations by DTXSID  = {}", dtxsid);

        List<ToxRefObs> data = repository.findAllByDtxsid(dtxsid, ToxRefObs.class);

        return data;
    }

    @Override
    public @ResponseBody
    List<ToxRefObs> toxRefObsByStudyType( String studyType) {
        log.debug("all Tox Ref Observations by Study Type = {}", studyType);

        List<ToxRefObs> data = repository.findAllByStudyType(studyType, ToxRefObs.class);
        log.debug("data size = {}", data.size());

        return data;
    }
}
