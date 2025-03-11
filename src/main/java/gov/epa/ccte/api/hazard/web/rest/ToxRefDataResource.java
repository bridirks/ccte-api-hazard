package gov.epa.ccte.api.hazard.web.rest;

import gov.epa.ccte.api.hazard.domain.ToxRefData;
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
    public @ResponseBody
    List<ToxRefData> toxRefDataByStudyId(Integer studyId) {
        log.debug("all Tox Ref Data by Study ID = {}", studyId);

        List<ToxRefData> data = repository.findAllByStudyId(studyId, ToxRefData.class);

        return data;
    }


    @Override
    public @ResponseBody
    List<ToxRefData> toxRefDataByDtxsid(String dtxsid) {
        log.debug("all Tox Ref Data by DTXSID = {}", dtxsid);

        List<ToxRefData> data = repository.findAllByDtxsid(dtxsid, ToxRefData.class);

        return data;
    }    


    @Override
    public @ResponseBody
    List<ToxRefData> toxRefDataByStudyType(String studyType) {
        log.debug("all Tox Ref Data by Study Type = {}", studyType);

        List<ToxRefData> data = repository.findAllByStudyType(studyType, ToxRefData.class);

        return data;
    }
}
