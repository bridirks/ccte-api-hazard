package gov.epa.ccte.api.hazard.config.swagger;

import io.swagger.v3.oas.models.examples.Example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class SwaggerExampleObject {

    @Value("classpath:static/examples/hazard/hazard-resource-examples.json")
    Resource testResource;

    @Bean
    public Map.Entry<String, List<Example>> hazardTestExamples() throws IOException, ParseException, IllegalAccessError {

        JSONObject json = (JSONObject) new JSONParser().parse(new InputStreamReader(testResource.getInputStream(), StandardCharsets.UTF_8));

        List<Example> exampleList = new ArrayList<>();
        AbstractMap.SimpleEntry<String, List<Example>> hazardExamplesMap = new AbstractMap.SimpleEntry<>("test", null);

        for (Object entry : json.keySet()){
            Example example = new Example();
            JSONObject exam = (JSONObject) json.get(entry);
            example.setValue(exam.get("results"));
            example.setDescription((String) exam.get("description"));
            example.setSummary((String) exam.get("summary"));
            exampleList.add(example);
        }

        hazardExamplesMap.setValue(exampleList);

        return hazardExamplesMap;
    }
}

