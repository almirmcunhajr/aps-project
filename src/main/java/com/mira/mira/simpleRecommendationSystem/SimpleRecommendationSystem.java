package com.mira.mira.simpleRecommendationSystem;

import com.mira.mira.recommendation.RecommendationSystem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SimpleRecommendationSystem implements RecommendationSystem {
    public ArrayList<String> getRecommendedGenres() {
        return new ArrayList<String>();
    }
}
