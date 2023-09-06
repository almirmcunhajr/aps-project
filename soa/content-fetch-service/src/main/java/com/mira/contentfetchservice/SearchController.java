package com.mira.contentfetchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class SearchController {
    private final MoviesService moviesService;

    @Autowired
    public SearchController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    public ArrayList<Content> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.addAll(moviesService.search(query, page));

        return contents;
    }
}
