package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.CancerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cancer_summary_vw", exported = true)
@RequestMapping(value = "hazard/cancer-summary")
public interface CancerSummaryRepository extends JpaRepository<CancerSummary, Integer> {
    List<CancerSummary> findAllByDtxsid(@Param("dtxsid") String dtxsid);
}
