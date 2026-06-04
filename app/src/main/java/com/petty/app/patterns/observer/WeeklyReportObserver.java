package com.petty.app.patterns.observer;

import com.petty.app.model.BehaviorLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<String, Integer> behaviorCount = new HashMap<>();
        for (BehaviorLog log : weeklyLogs) {
            String behavior = log.getBehavior();
            behaviorCount.put(behavior, behaviorCount.getOrDefault(behavior, 0) + 1);
        }

        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : behaviorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("Haftalık Rapor\n");
        report.append("Toplam kayıt: ").append(weeklyLogs.size()).append("\n\n");
        report.append("En sık görülen davranış: ").append(mostCommon)
                .append(" (").append(maxCount).append(" kez)\n\n");
        report.append("Tüm davranışlar:\n");
        for (Map.Entry<String, Integer> entry : behaviorCount.entrySet()) {
            report.append("• ").append(entry.getKey())
                    .append(": ").append(entry.getValue()).append(" kez\n");
        }
        return report.toString();
    }
}