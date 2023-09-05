package com.mira.mira.recommendation;

import com.mira.mira.simpleRecommendationSystem.SimpleRecommendationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RecommendationsController {
    public final RecommendationSystem recommendationSystem;

    @Autowired
    public RecommendationsController(SimpleRecommendationSystem simpleRecommendationSystem) {
        this.recommendationSystem = simpleRecommendationSystem;
    }

    public ArrayList<String> getRecommendedGenres() {
        return recommendationSystem.getRecommendedGenres();
    }
}
