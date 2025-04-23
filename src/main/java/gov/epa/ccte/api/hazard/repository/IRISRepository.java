package gov.epa.ccte.api.hazard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.hazard.domain.IRIS;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface IRISRepository extends JpaRepository<IRIS, String>{

    @Transactional(readOnly = true)
    <T>List<T> findByDtxsid(String dtxsid);
}
