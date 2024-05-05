package dev.mbonigabay.validationdoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI serviceAPI(){
        return new OpenAPI()
        .info(new Info().title("MY Validation App")
        .description("This ia the REST API")
        .version("1.0.0")
        .license(new License().name("Apache 2.0")))
        .externalDocs(new ExternalDocumentation()
        .description("Please refer to this")
        .url("https://dummy.com"));
    }
}
