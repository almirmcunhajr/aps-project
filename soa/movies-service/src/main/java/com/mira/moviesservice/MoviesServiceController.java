package com.mira.moviesservice;

import com.mira.moviesservice.tmdb.TmdbMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class MoviesServiceController {
    private final MoviesService moviesService;

    @Autowired
    public MoviesServiceController(TmdbMoviesService tmdbMoviesService) {
        this.moviesService = tmdbMoviesService;
    }

    public ArrayList<Movie> search(String query, int page) throws IOException, InterruptedException {
        return moviesService.search(query, page);
    }

    public ArrayList<Movie> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        return moviesService.discoverByGenres(genres, page);
    }

    public ArrayList<Movie> getPopular(int page, String region) throws IOException, InterruptedException {
        return moviesService.getPopular(page, region);
    }
}
