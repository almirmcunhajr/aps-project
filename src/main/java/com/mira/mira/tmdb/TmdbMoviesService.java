package com.mira.mira.tmdb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mira.mira.getContent.Movie;
import com.mira.mira.getContent.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class TmdbMoviesService implements MoviesService {
    private final TmdbApi tmdbApi;

    @Autowired
    public TmdbMoviesService(TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    public ArrayList<Movie> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Movie> movies = new ArrayList<>();

        String response = tmdbApi.searchMovies(query, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Movie movie = new Movie();
            movie.title = result.path("title").asText();
            movie.overview = result.path("overview").asText();
            movie.language = result.path("original_language").asText();
            movie.extId = result.path("id").asInt();
            movies.add(movie);
        }

        return movies;
    }

    public ArrayList<Movie> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        ArrayList<Movie> movies = new ArrayList<>();

        String genresFilter = String.join("OR", genres);

        String response = tmdbApi.discoverMovies(genresFilter, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Movie movie = new Movie();
            movie.title = result.path("title").asText();
            movie.overview = result.path("overview").asText();
            movie.language = result.path("original_language").asText();
            movie.extId = result.path("id").asInt();
            movies.add(movie);
        }

        return movies;
    }

    public ArrayList<Movie> getPopular(int page, String region) throws IOException, InterruptedException {
        ArrayList<Movie> movies = new ArrayList<>();

        String response = tmdbApi.getPopularMovies(page, region);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Movie movie = new Movie();
            movie.title = result.path("title").asText();
            movie.overview = result.path("overview").asText();
            movie.language = result.path("original_language").asText();
            movie.extId = result.path("id").asInt();
            movies.add(movie);
        }

        return movies;
    }
}
