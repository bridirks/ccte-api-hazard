package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.Ecotox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ecotox", path = "ecotox", exported = false)
public interface EcotoxRepository extends JpaRepository<Ecotox, Integer> {
    List<Ecotox> findAllByDtxsid(@Param("dtxsid") String dtxsid);
}
