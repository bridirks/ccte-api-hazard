package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.ToxRefEffects;
import gov.epa.ccte.api.hazard.repository.ToxRefEffectsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ToxRefEffectsResource implements ToxRefEffectsApi {

    private final ToxRefEffectsRepository repository;


    public ToxRefEffectsResource(ToxRefEffectsRepository repository) {
        this.repository = repository;
    }

    @Override
    public @ResponseBody
    List<ToxRefEffects> toxRefEffectsByStudyId(Integer studyId) {
        log.debug("all Tox Ref Effects by Study ID = {}", studyId);

        List<ToxRefEffects> data = repository.findAllByStudyId(studyId, ToxRefEffects.class);

        return data;
    }


    @Override
    public @ResponseBody
    List<ToxRefEffects> toxRefEffectsByDtxsid(String dtxsid) {
        log.debug("all Tox Ref Effects by DTXSID = {}", dtxsid);

        List<ToxRefEffects> data = repository.findAllByDtxsid(dtxsid, ToxRefEffects.class);

        return data;
    }    


    @Override
    public @ResponseBody
    List<ToxRefEffects> toxRefEffectsByStudyType(String studyType) {
        log.debug("all Tox Ref Effects by Study Type = {}", studyType);

        List<ToxRefEffects> data = repository.findAllByStudyType(studyType, ToxRefEffects.class);

        return data;
    }
}

