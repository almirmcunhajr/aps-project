package com.mira.moviesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class MoviesServiceRestController {
    private final MoviesServiceController moviesServiceController;

    @Autowired
    public MoviesServiceRestController(MoviesServiceController moviesServiceController) {
        this.moviesServiceController = moviesServiceController;
    }

    @GetMapping("/search")
    public ArrayList<Movie> search(String query, int page) throws IOException, InterruptedException {
        return moviesServiceController.search(query, page);
    }

    @GetMapping("/discoverbygenres")
    public ArrayList<Movie> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        return moviesServiceController.discoverByGenres(genres, page);
    }

    @GetMapping("/getpopular")
    public ArrayList<Movie> getPopular(int page, String region) throws IOException, InterruptedException {
        return moviesServiceController.getPopular(page, region);
    }
}
