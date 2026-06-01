package com.petty.app.patterns.observer;

import com.petty.app.model.BehaviorLog;

import java.util.ArrayList;

import java.util.List;

public class WeeklyReportObserver implements BehaviorObserver {

    private List<BehaviorLog> weeklyLogs = new ArrayList<>();

    @Override

    public void onBehaviorLogged(BehaviorLog log) {

        weeklyLogs.add(log);

    }

    public List<BehaviorLog> getWeeklyLogs() {

        return weeklyLogs;

    }

    public String generateWeeklyReport() {

        if (weeklyLogs.isEmpty()) {

            return "Bu hafta henüz veri girilmedi.";

        }

        StringBuilder report = new StringBuilder("Haftalık Rapor:\n");

        report.append("Toplam kayıt: ").append(weeklyLogs.size()).append("\n");

        for (BehaviorLog log : weeklyLogs) {

            report.append("- ").append(log.getBehavior());

            if (log.getRecommendation() != null) {

                report.append(" → ").append(log.getRecommendation());

            }

            report.append("\n");

        }

        return report.toString();

    }

}
