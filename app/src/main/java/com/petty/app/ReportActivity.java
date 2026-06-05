package com.petty.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.petty.app.database.PetRepository;
import com.petty.app.model.BehaviorLog;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        TextView tvDailyReport = findViewById(R.id.tvDailyReport);
        TextView tvWeeklyReport = findViewById(R.id.tvWeeklyReport);
        Button btnBackHome = findViewById(R.id.btnBackHome);

        PetRepository repository = new PetRepository(this);

        long oneDayAgo = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
        long oneWeekAgo = System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000);

        repository.getLogsSince(oneDayAgo, logs -> runOnUiThread(() -> {
            if (logs.isEmpty()) {
                tvDailyReport.setText("Bugün henüz veri girilmedi.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (BehaviorLog log : logs) {
                    sb.append("• ").append(log.getBehavior());
                    if (log.getSubReason() != null) {
                        sb.append(" / ").append(log.getSubReason());
                    }
                    sb.append("\n");
                    if (log.getRecommendation() != null) {
                        sb.append(log.getRecommendation()).append("\n\n");
                    }
                }
                tvDailyReport.setText(sb.toString());
            }
        }));

        repository.getLogsSince(oneWeekAgo, logs -> runOnUiThread(() -> {
            if (logs.isEmpty()) {
                tvWeeklyReport.setText("Bu hafta henüz veri girilmedi.");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Toplam kayıt: ").append(logs.size()).append("\n\n");
                for (BehaviorLog log : logs) {
                    sb.append("• ").append(log.getBehavior());
                    if (log.getSubReason() != null) {
                        sb.append(" / ").append(log.getSubReason());
                    }
                    sb.append("\n");
                }
                tvWeeklyReport.setText(sb.toString());
            }
        }));

        btnBackHome.setOnClickListener(v -> finish());
    }
}