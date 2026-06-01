package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public interface RecommendationStrategy {
    String getRecommendation(BehaviorLog log);
}