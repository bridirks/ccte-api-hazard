package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.Hazard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "hazard", path = "hazard", exported = false)
public interface HazardRepository extends PagingAndSortingRepository<Hazard, Integer> {

    @Transactional(readOnly = true)
    @RestResource(rel = "findByDtxsid", path = "by-dtxsid", exported = false)
    List<Hazard> findByDtxsid(String dtxsid);
}
