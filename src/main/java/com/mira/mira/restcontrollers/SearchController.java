package com.mira.mira.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mira.mira.entities.Content;
import com.mira.mira.controllers.GetContentController;

import java.io.IOException;
import java.util.List;

@RestController
public class SearchController {
    private final GetContentController getContentController;

    @Autowired
    public SearchController(GetContentController getContentController) {
        this.getContentController = getContentController;
    }

    @GetMapping("/search")
    public List<Content> search(String query, int page) throws IOException, InterruptedException {
        return getContentController.getContents(query, page);
    }
}
