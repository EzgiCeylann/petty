package com.petty.app.patterns.observer;

import com.petty.app.model.BehaviorLog;

public interface BehaviorObserver {
    void onBehaviorLogged(BehaviorLog log);
}