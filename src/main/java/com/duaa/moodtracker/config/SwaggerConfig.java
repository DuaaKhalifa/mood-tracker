package com.duaa.moodtracker.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI moodTrackerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mood Tracker API")
                        .version("v1.0")
                        .description("This API allows users to track their mood, stress level, and associated tags."));
    }
}
