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
    List toxRefEffectsByStudyId(Integer studyId, ToxRefEffectsProjection projection) {
        log.debug("all Tox Ref Effects by Study ID = {}", studyId);

        return switch (projection) {
            case ToxRefEffectsSummary -> repository.findAllByStudyId(studyId, ToxRefEffectsSummary.class);
            case ToxRefEffectsAll -> repository.findAllByStudyId(studyId, ToxRefEffectsAll.class);
        };
    }

    @Override
    public @ResponseBody
    List toxRefEffectsByDtxsid(String dtxsid, ToxRefEffectsProjection projection) {
        log.debug("all Tox Ref Effects by DTXSID  = {}", dtxsid);

        return switch (projection) {
            case ToxRefEffectsSummary -> repository.findAllByDtxsid(dtxsid, ToxRefEffectsSummary.class);
            case ToxRefEffectsAll -> repository.findAllByDtxsid(dtxsid, ToxRefEffectsAll.class);
        };
    }

    @Override
    public @ResponseBody
    List toxRefEffectsByStudyType(String studyType, ToxRefEffectsProjection projection) {
        log.debug("all Tox Ref Effects by Study Type = {}", studyType);

        return switch (projection) {
            case ToxRefEffectsSummary -> repository.findAllByStudyType(studyType, ToxRefEffectsSummary.class);
            case ToxRefEffectsAll -> repository.findAllByStudyType(studyType, ToxRefEffectsAll.class);
        };
    }
}

