package com.mira.mira.controllers;

import com.mira.mira.adapters.TmdbMovies;
import com.mira.mira.adapters.TmdbTvs;
import com.mira.mira.interfaces.Movies;
import com.mira.mira.interfaces.Tvs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mira.mira.entities.*;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class GetContentController {

    private final Movies movies;
    private final Tvs tvs;

    @Autowired
    public GetContentController (TmdbMovies tmdbMovies, TmdbTvs tmdbTvs) {
        this.movies = tmdbMovies;
        this.tvs = tmdbTvs;
    }

    public ArrayList<Content> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(movies.search(query, page));
        contents.addAll(tvs.search(query, page));

        return contents;
    }

    public ArrayList<Content> discoverByGenre(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(movies.discoverByGenres(genres, page));
        contents.addAll(tvs.discoverByGenres(genres, page));

        return contents;
    }
}