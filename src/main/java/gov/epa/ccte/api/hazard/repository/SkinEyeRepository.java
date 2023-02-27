package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.SkinEye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "skin_eye_vw", exported = false)
public interface SkinEyeRepository extends JpaRepository<SkinEye, Integer> {
    List<SkinEye> findAllByDtxsid(@Param("dtxsid") String dtxsid);
}
