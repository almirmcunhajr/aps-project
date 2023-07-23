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
import java.util.List;

@Component
public class GetContentController {

    private final Movies movies;
    private final Tvs tvs;

    @Autowired
    public GetContentController (TmdbMovies tmdbMovies, TmdbTvs tmdbTvs) {
        this.movies = tmdbMovies;
        this.tvs = tmdbTvs;
    }

    public List<Content> getContents(String query, int page) throws IOException, InterruptedException {
        List<Content> contents = new ArrayList<>();

        contents.addAll(movies.getMovies(query, page));
        contents.addAll(tvs.getTvs(query, page));

        return contents;
    }
}