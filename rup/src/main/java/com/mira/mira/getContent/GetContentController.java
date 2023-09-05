package com.mira.mira.getContent;

import com.mira.mira.tmdb.TmdbMoviesService;
import com.mira.mira.tmdb.TmdbShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class GetContentController {

    private final MoviesService moviesService;
    private final ShowsService showsService;

    @Autowired
    public GetContentController (TmdbMoviesService tmdbMoviesService, TmdbShowsService tmdbShowsService) {
        this.moviesService = tmdbMoviesService;
        this.showsService = tmdbShowsService;
    }

    public ArrayList<Content> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(moviesService.search(query, page));
        contents.addAll(showsService.search(query, page));

        return contents;
    }

    public ArrayList<Content> discoverByGenre(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(moviesService.discoverByGenres(genres, page));
        contents.addAll(showsService.discoverByGenres(genres, page));

        return contents;
    }

    public ArrayList<Content> getPopular(int page, String region) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(moviesService.getPopular(page, region));
        contents.addAll(showsService.getPopular(page, region));

        return contents;
    }
}