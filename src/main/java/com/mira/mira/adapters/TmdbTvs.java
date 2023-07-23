package com.mira.mira.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mira.mira.boundaries.TmdbApi;
import com.mira.mira.entities.Tv;
import com.mira.mira.interfaces.Tvs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class TmdbTvs implements Tvs {
    private final TmdbApi tmdbApi;

    @Autowired
    public TmdbTvs (TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    public ArrayList<Tv> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Tv> tvs = new ArrayList<>();

        String response = tmdbApi.searchTvs(query, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Tv tv = new Tv();
            tv.title = result.path("title").asText();
            tv.overview = result.path("overview").asText();
            tv.language = result.path("original_language").asText();
            tvs.add(tv);
        }

        return tvs;
    }

    public ArrayList<Tv> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        ArrayList<Tv> tvs = new ArrayList<>();

        String genresFilter = String.join("OR", genres);

        String response = tmdbApi.discoverTvs(genresFilter, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Tv tv = new Tv();
            tv.title = result.path("title").asText();
            tv.overview = result.path("overview").asText();
            tv.language = result.path("original_language").asText();
            tvs.add(tv);
        }

        return tvs;
    }
}
