package com.mira.mira.restcontrollers;

import com.mira.mira.controllers.GetContentController;
import com.mira.mira.controllers.RecommendationsController;
import com.mira.mira.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ExplorationController {
    private final GetContentController getContentController;
    private final RecommendationsController recommendationsController;

    @Autowired
    public ExplorationController(GetContentController getContentController, RecommendationsController recommendationsController) {
        this.getContentController = getContentController;
        this.recommendationsController = recommendationsController;
    }

    @GetMapping("/explore")
    public ArrayList<Content> explore(int page) throws IOException, InterruptedException {
        ArrayList<String> recommendedGenres = recommendationsController.getRecommendations();
        return getContentController.discoverByGenre(recommendedGenres, page);
    }
}
