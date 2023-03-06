package gov.epa.ccte.api.hazard.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


//@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Computational Toxicology and Exposure Data APIs - Hazard",
                description = "This is the part of CCTE Public APIs and provides hazard data through a set of API endpoints. User has the option to get all the data or only data related to human health or related to eco tox.",
                contact = @Contact(
                        name = "",
                        url = "",
                        email = "ccte_api@epa.gov"),
                version = "1.0.0"
        ),
        servers = @Server(url = "http://api-ccte.epa.gov")
)
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "api_key",
        in = SecuritySchemeIn.HEADER,
        description = "Each API call should have api_key, Contact author for getting the new api_key. ",
        paramName = "x-api-key"
)
public class OpenApiConfig {
}
