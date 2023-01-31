package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.Hazard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "hazard", path = "hazard", exported = false)
public interface HazardRepository extends PagingAndSortingRepository<Hazard, Integer> {

    @Transactional(readOnly = true)
    @Query("select h from Hazard h where h.dtxsid = ?1 order by h.humanEcoNt, h.source")
    List<Hazard> findAllByDtxsid(String dtxsid);

    @Transactional(readOnly = true)
    @Query("select h from Hazard h where h.dtxsid = ?1 and h.humanEcoNt = 'eco' order by h.source")
    List<Hazard> findEcoDataByDtxsid(String dtxsid);

    @Transactional(readOnly = true)
    @Query("select h from Hazard h where h.dtxsid = ?1 and h.humanEcoNt = 'human health' order by h.source")
    List<Hazard> findHumanDataByDtxsid(String dtxsid);

}
