package com.mira.mira.exploration;

import com.mira.mira.getContent.GetContentController;
import com.mira.mira.getContent.Content;
import com.mira.mira.recommendation.RecommendationsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class ExplorationController {
    private final GetContentController getContentController;
    private final RecommendationsController recommendationsController;

    @Autowired
    public ExplorationController(GetContentController getContentController, RecommendationsController recommendationsController) {
        this.getContentController = getContentController;
        this.recommendationsController = recommendationsController;
    }

    public ArrayList<Content> explore(int page) throws IOException, InterruptedException {
        ArrayList<String> recommendedGenres = recommendationsController.getRecommendedGenres();

        if (recommendedGenres.isEmpty())
            return getContentController.getPopular(page, "US");
        else
            return getContentController.discoverByGenre(recommendedGenres, page);
    }
}
