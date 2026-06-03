package com.petty.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.petty.app.manager.BehaviorLogManager;
import com.petty.app.patterns.observer.DailyReportObserver;
import com.petty.app.patterns.observer.WeeklyReportObserver;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        TextView tvDailyReport = findViewById(R.id.tvDailyReport);
        TextView tvWeeklyReport = findViewById(R.id.tvWeeklyReport);
        Button btnBackHome = findViewById(R.id.btnBackHome);

        BehaviorLogManager manager = BehaviorLogManager.getInstance();

        DailyReportObserver dailyObserver = new DailyReportObserver();
        WeeklyReportObserver weeklyObserver = new WeeklyReportObserver();

        manager.addObserver(dailyObserver);
        manager.addObserver(weeklyObserver);

        tvDailyReport.setText(dailyObserver.generateDailyReport());
        tvWeeklyReport.setText(weeklyObserver.generateWeeklyReport());

        btnBackHome.setOnClickListener(v -> finish());
    }
}