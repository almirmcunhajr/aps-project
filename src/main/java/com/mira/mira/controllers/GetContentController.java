package com.mira.mira.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mira.mira.boundaries.TmdbApi;
import com.mira.mira.entities.Content;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetContentController {

    private final TmdbApi tmdbApi;

    @Autowired
    public GetContentController (TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    public List<Content> getContents(String query, int page) throws IOException, InterruptedException {
        List<Content> contents = new ArrayList<>();

        String response = tmdbApi.searchMovie(query, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Content content = new Content();
            content.title = result.path("title").asText();
            content.overview = result.path("overview").asText();
            content.language = result.path("original_language").asText();
            contents.add(content);
        }

        return contents;
    }
}