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
public class ToxRefDataResource implements ToxRefDataApi {
    private final ToxRefDataRepository repository;

    public ToxRefDataResource(ToxRefDataRepository repository) {
        this.repository = repository;
    }

    @Override
    @ResponseBody
    public List toxRefDataByStudyId(Integer studyId, ToxRefDataProjection projection) {
        log.debug("all Tox Ref Data by Study ID = {}", studyId);

        return switch (projection) {
            case ToxRefDataSummary -> repository.findAllByStudyId(studyId, ToxRefDataSummary.class);
            case ToxRefDataAll -> repository.findAllByStudyId(studyId, ToxRefDataAll.class);
        };

    }

    @Override
    @ResponseBody
    public List toxRefDataByDtxsid(String dtxsid, ToxRefDataProjection projection) {
        log.debug("all Tox Ref Data by DTXSID  = {}", dtxsid);

        return switch (projection) {
            case ToxRefDataSummary -> repository.findAllByDtxsid(dtxsid, ToxRefDataSummary.class);
            case ToxRefDataAll -> repository.findAllByDtxsid(dtxsid, ToxRefDataAll.class);
        };
    }

    @ResponseBody
    public List toxRefDataByStudyType(String studyType, ToxRefDataProjection projection) {
        log.debug("all Tox Ref Data by Study Type = {}", studyType);

        return switch (projection) {
            case ToxRefDataSummary -> repository.findAllByStudyType(studyType, ToxRefDataSummary.class);
            case ToxRefDataAll -> repository.findAllByStudyType(studyType, ToxRefDataAll.class);
        };

    }
}
