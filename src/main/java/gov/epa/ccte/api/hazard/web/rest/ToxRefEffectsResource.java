package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.projection.toxrefeffects.ToxRefEffectsAll;
import gov.epa.ccte.api.hazard.projection.toxrefeffects.ToxRefEffectsProjection;
import gov.epa.ccte.api.hazard.projection.toxrefeffects.ToxRefEffectsSummary;
import gov.epa.ccte.api.hazard.repository.ToxRefEffectsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ToxRefEffectsResource implements ToxRefEffectsResourceApi {

    private final ToxRefEffectsRepository repository;


    public ToxRefEffectsResource(ToxRefEffectsRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<ToxRefEffectsAll> toxRefEffectsByStudyId(Integer studyId) {
        log.debug("all Tox Ref Effects by Study ID = {}", studyId);

        List<ToxRefEffectsAll> data = repository.findAllByStudyId(studyId, ToxRefEffectsAll.class);

        return data;
    }


    @Override
    public @ResponseBody
    List<ToxRefEffectsAll> toxRefEffectsByDtxsid(String dtxsid) {
        log.debug("all Tox Ref Effects by DTXSID = {}", dtxsid);

        List<ToxRefEffectsAll> data = repository.findAllByDtxsid(dtxsid, ToxRefEffectsAll.class);

        return data;
    }    


    @Override
    public @ResponseBody
    List<ToxRefEffectsAll> toxRefEffectsByStudyType(String studyType) {
        log.debug("all Tox Ref Effects by Study Type = {}", studyType);

        List<ToxRefEffectsAll> data = repository.findAllByStudyType(studyType, ToxRefEffectsAll.class);

        return data;
    }
}

