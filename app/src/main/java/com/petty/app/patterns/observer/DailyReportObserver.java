package com.petty.app.patterns.observer;

import com.petty.app.model.BehaviorLog;

import java.util.ArrayList;

import java.util.List;

public class DailyReportObserver implements BehaviorObserver {

    private List<BehaviorLog> dailyLogs = new ArrayList<>();

    @Override

    public void onBehaviorLogged(BehaviorLog log) {

        dailyLogs.add(log);

    }

    public List<BehaviorLog> getDailyLogs() {

        return dailyLogs;

    }

    public String generateDailyReport() {

        if (dailyLogs.isEmpty()) {

            return "Bugün henüz veri girilmedi.";

        }

        StringBuilder report = new StringBuilder("Günlük Rapor:\n");

        for (BehaviorLog log : dailyLogs) {

            report.append("- ").append(log.getBehavior());

            if (log.getRecommendation() != null) {

                report.append(" → ").append(log.getRecommendation());

            }

            report.append("\n");

        }

        return report.toString();

    }

}
