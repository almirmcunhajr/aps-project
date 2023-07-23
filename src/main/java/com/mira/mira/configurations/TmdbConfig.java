package com.mira.mira.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TmdbConfig {

    @Value("${tmdb.apikey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
