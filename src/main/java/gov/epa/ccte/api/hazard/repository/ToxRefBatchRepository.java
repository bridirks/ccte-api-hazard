package gov.epa.ccte.api.hazard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.hazard.domain.ToxRefBatch;

public interface ToxRefBatchRepository extends JpaRepository<ToxRefBatch, Integer>{

    @Transactional(readOnly = true)
    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);
}
