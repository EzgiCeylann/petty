package com.petty.app.manager;

import com.petty.app.model.BehaviorLog;

import com.petty.app.patterns.observer.BehaviorObserver;

import com.petty.app.patterns.strategy.RecommendationStrategy;

import com.petty.app.patterns.strategy.CatRecommendationStrategy;

import com.petty.app.patterns.strategy.DogRecommendationStrategy;

import java.util.ArrayList;

import java.util.List;

public class BehaviorLogManager {

    private static BehaviorLogManager instance;

    private List<BehaviorObserver> observers = new ArrayList<>();

    private RecommendationStrategy strategy;

    private BehaviorLogManager() {}

    public static BehaviorLogManager getInstance() {

        if (instance == null) {

            instance = new BehaviorLogManager();

        }

        return instance;

    }

    public void setPetType(String petType) {

        if (petType.equals("cat")) {

            strategy = new CatRecommendationStrategy();

        } else {

            strategy = new DogRecommendationStrategy();

        }

    }

    public void addObserver(BehaviorObserver observer) {

        observers.add(observer);

    }

    public void removeObserver(BehaviorObserver observer) {

        observers.remove(observer);

    }

    public String logBehavior(BehaviorLog log) {

        String recommendation = strategy.getRecommendation(log);

        log.setRecommendation(recommendation);

        notifyObservers(log);

        return recommendation;

    }

    private void notifyObservers(BehaviorLog log) {

        for (BehaviorObserver observer : observers) {

            observer.onBehaviorLogged(log);

        }

    }

}
