package com.mira.mira.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mira.mira.boundaries.TmdbApi;
import com.mira.mira.entities.*;

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

    public List<Movie> getMovies(String query, int page) throws IOException, InterruptedException {
        List<Movie> movies = new ArrayList<>();

        String response = tmdbApi.searchMovie(query, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Movie movie = new Movie();
            movie.title = result.path("title").asText();
            movie.overview = result.path("overview").asText();
            movie.language = result.path("original_language").asText();
            movies.add(movie);
        }

        return movies;
    }

    public List<Tv> getTvs(String query, int page) throws IOException, InterruptedException {
        List<Tv> tvs = new ArrayList<>();

        String response = tmdbApi.searchTv(query, page);

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

    public List<Content> getContents(String query, int page) throws IOException, InterruptedException {
        List<Content> contents = new ArrayList<>();

        contents.addAll(getMovies(query, page));
        contents.addAll(getTvs(query, page));

        return contents;
    }
}