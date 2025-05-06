package gov.epa.ccte.api.hazard.webtest;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import lombok.val;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ToxValDbResourceTest {
    @Autowired
    private WebTestClient webTestClient;
    
    // Test the endpoint for getting ToxValDb data by dtxsid
    @Test
    void testToxValDbByDtxsidForPositiveResponse() {
        webTestClient.get().uri("hazard/toxval/search/by-dtxsid/DTXSID0021125").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON);
	}
    
    // Test the endpoint for getting ToxValDb data by batch of dtxsid
    @Test
    void testToxValDbByBatchDtxsidForPositiveResponse() {
    	val requestBody = "[" + "\"DTXSID7020182\"," + "\"DTXSID9020112\"]";
        webTestClient.post().uri("hazard/toxval/search/by-dtxsid/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestBody))
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON);
	}

}
