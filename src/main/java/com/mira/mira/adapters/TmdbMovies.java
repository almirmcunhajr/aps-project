package com.mira.mira.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mira.mira.boundaries.TmdbApi;
import com.mira.mira.entities.Movie;
import com.mira.mira.interfaces.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class TmdbMovies implements Movies {
    private final TmdbApi tmdbApi;

    @Autowired
    public TmdbMovies (TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    @Override
    public ArrayList<Movie> getMovies(String query, int page) throws IOException, InterruptedException {
        ArrayList<Movie> movies = new ArrayList<>();

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
}
