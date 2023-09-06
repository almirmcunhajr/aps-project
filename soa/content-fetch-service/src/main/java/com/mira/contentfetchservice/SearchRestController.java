package com.mira.contentfetchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class SearchRestController {
    private final SearchController searchController;

    @Autowired
    public SearchRestController(SearchController searchController) {
        this.searchController = searchController;
    }

    @GetMapping("/search")
    public ArrayList<Content> search(String query, int page) throws IOException, InterruptedException {
        return searchController.search(query, page);
    }
}
