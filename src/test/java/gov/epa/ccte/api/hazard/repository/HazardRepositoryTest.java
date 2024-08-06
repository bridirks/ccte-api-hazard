package gov.epa.ccte.api.hazard.repository;

import gov.epa.ccte.api.hazard.projection.HazardAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class HazardRepositoryTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> pgsqldb = new PostgreSQLContainer<>("postgres:13-alpine");

    @Autowired
    private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private TestEntityManager entityManager;
    @Autowired private HazardRepository repository;

    @Test
    void connectionEstablished(){
        assertThat(pgsqldb.isCreated()).isTrue();
        assertThat(pgsqldb.isRunning()).isTrue();
    }

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(repository).isNotNull();
    }

    // Now test data loaded or not
    @Test
    void testDataLoaded() {assertThat(repository.findAll().size()).isEqualTo(29);}

    @Test
    void findAllByDtxsid() { assertThat(repository.findAllByDtxsid(new String[] {"DTXSID0029054"}, HazardAll.class)).isNotNull(); }

    @Test
    void findEcoDataByDtxsid() { assertThat(repository.findEcoDataByDtxsid(new String[] {"DTXSID0029054"}, HazardAll.class)).isNotNull(); }

    @Test
    void findHumanDataByDtxsid() { assertThat(repository.findHumanDataByDtxsid(new String[] {"DTXSID0029054"}, HazardAll.class)).isNotNull(); }
}