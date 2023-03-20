package gov.epa.ccte.api.hazard.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.epa.ccte.api.hazard.springdocexamples.cancersummary.CancerSummaryExample;
import gov.epa.ccte.api.hazard.springdocexamples.ecotox.EcotoxExample;
import gov.epa.ccte.api.hazard.springdocexamples.hazard.HazardExample;
import gov.epa.ccte.api.hazard.springdocexamples.skineye.SkinEyeExample;
import io.swagger.v3.oas.models.examples.Example;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class SwaggerExampleObject {

    @Value("classpath:examples/hazard/hazard-resource-examples.json")
    Resource hazardResourceExamples;

    @Value("classpath:examples/skineye/skineye-resource-examples.json")
    Resource skinEyeResourceExamples;

    @Value("classpath:examples/cancersummary/cancersummary-resource-examples.json")
    Resource cancerSummaryResourceExamples;

    @Value("classpath:examples/ecotox/ecotox-resource-examples.json")
    Resource ecotoxResourceExamples;
    @Bean
    public Map.Entry<String, List<Example>> hazardTestExamples() throws IOException, IllegalAccessError {

        ObjectMapper mapper = new ObjectMapper();

        // Load all examples from JSON files
        HazardExample[] hazardExamples = mapper.readValue(hazardResourceExamples.getInputStream(), HazardExample[].class);
        SkinEyeExample[] skinEyeExamples = mapper.readValue(skinEyeResourceExamples.getInputStream(), SkinEyeExample[].class);
        CancerSummaryExample[] cancerSummaryExamples = mapper.readValue(cancerSummaryResourceExamples.getInputStream(), CancerSummaryExample[].class);
        EcotoxExample[] ecotoxExamples = mapper.readValue(ecotoxResourceExamples.getInputStream(), EcotoxExample[].class
        );

        List<Example> exampleList = new ArrayList<>();
        AbstractMap.SimpleEntry<String, List<Example>> hazardExamplesMap = new AbstractMap.SimpleEntry<>("examples", null);

        // Add Hazard Examples
        for (HazardExample entry : hazardExamples) {
            Example example = convertExample(entry.getResults(), entry.getDescription(), entry.getIdentifier(), entry.getSummary());
            exampleList.add(example);
        }

        // Add Skin Eye Examples
        for (SkinEyeExample entry : skinEyeExamples) {
            Example example = convertExample(entry.getResults(), entry.getDescription(), entry.getIdentifier(), entry.getSummary());
            exampleList.add(example);
        }

        // Add Cancer Summary Examples
        for (CancerSummaryExample entry : cancerSummaryExamples) {
            Example example = convertExample(entry.getResults(), entry.getDescription(), entry.getIdentifier(), entry.getSummary());
            exampleList.add(example);
        }

        // Add Ecotox Examples
        for (EcotoxExample entry : ecotoxExamples) {
            Example example = convertExample(entry.getResults(), entry.getDescription(), entry.getIdentifier(), entry.getSummary());
            exampleList.add(example);
        }

        hazardExamplesMap.setValue(exampleList);

        return hazardExamplesMap;
    }

    private Example convertExample(Object results, String description, String ref, String summary) {
        Example example = new Example();
        example.setValue(results);
        example.setSummary(summary);
        example.setDescription(description);
        example.set$ref(ref);
        return example;
    }
}

