package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.domain.ToxValDb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface ToxValDbRepository extends PagingAndSortingRepository<ToxValDb, Integer> {

    @Transactional(readOnly = true)
    @Query("select t from ToxValDb t where t.dtxsid in (?1) order by t.humanEco, t.source")
    <T>
    List<T> findAllByDtxsid(String[] dtxsid, Class<T> type);

    @Transactional(readOnly = true)
    @Query("select t from ToxValDb t where t.dtxsid in (?1) and t.humanEco = 'eco' order by t.source")
    <T>
    List<T> findEcoDataByDtxsid(String[] dtxsid, Class<T> type);

    @Transactional(readOnly = true)
    @Query("select t from ToxValDb t where t.dtxsid in (?1) and t.humanEco = 'human health' order by t.source")
    <T>
    List<T> findHumanDataByDtxsid(String[] dtxsid, Class<T> type);

    // Needed for data layer unit tests
    Collection<Object> findAll();
}
