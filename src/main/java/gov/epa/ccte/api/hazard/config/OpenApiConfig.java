package gov.epa.ccte.api.hazard.config;

import gov.epa.ccte.api.hazard.config.swagger.SwaggerExampleObject;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.examples.Example;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Computational Toxicology and Exposure Data APIs - Hazard",
                description = "The Hazard APIs are part of a set of public computational toxicology and exposure APIs and provide hazard data through a set of API endpoints. Users have the option to get all the data or only data related to human health or related to ecotoxicology.",
                contact = @Contact(
                        name = "",
                        url = "",
                        email = ""),
                version = "1.0.0"
        ),
        servers = { @Server(url = "https://api-ccte.epa.gov", description = "Production Environment"),
                @Server(url = "https://api-ccte-stg.epa.gov", description = "Staging Environment")
        }
        )
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "api_key",
        in = SecuritySchemeIn.HEADER,
        description = "Each API call should have api_key, Contact author for getting the new api_key. ",
        paramName = "x-api-key"
)
public class OpenApiConfig {

        @Autowired
        SwaggerExampleObject swaggerExampleObject;

        @Bean
        public OpenApiCustomiser openApiCustomiser(Collection<Map.Entry<String, List<Example>>> examples) {
                return openAPI -> examples.forEach(example -> {
                        for(Example e : example.getValue()){
                                String referenceKeyName = e.get$ref().substring(e.get$ref().lastIndexOf("/") + 1);
                                openAPI.getComponents().addExamples(referenceKeyName, e);
                        }
                });
        }

}
