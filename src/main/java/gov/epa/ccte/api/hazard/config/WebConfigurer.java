package gov.epa.ccte.api.hazard.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.util.Collections;


/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment env;


    public WebConfigurer(Environment env) {
        this.env = env;
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }

        log.info("Web application fully configured");
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setExposedHeaders(Collections.singletonList("Authorization"));
        config.setAllowCredentials(false);
        //config.setMaxAge(3600);
        source.registerCorsConfiguration("/**", config);
        CorsFilter filter = new CorsFilter(source);
//        filter.setCorsProcessor(new DefaultCorsProcessor() {
//            @Override
//            public boolean processRequest(CorsConfiguration config, HttpServletRequest request, HttpServletResponse response)
//                    throws IOException {
//                if ("OPTIONS".equals(request.getMethod()) && "/hazard/**".equals(request.getRequestURI())) {
//                    // Exclude the API endpoint from preflight checks
//                    return true;
//                }
//                return super.processRequest(config, request, response);
//            }
//        });
        return filter;
    }
}