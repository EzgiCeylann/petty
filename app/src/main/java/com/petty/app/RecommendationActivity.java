package com.petty.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.petty.app.manager.BehaviorLogManager;
import com.petty.app.model.BehaviorLog;

public class RecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        String behavior = getIntent().getStringExtra("behavior");
        String subReason = getIntent().getStringExtra("sub_reason");
        String petName = getIntent().getStringExtra("pet_name");
        String petType = getIntent().getStringExtra("pet_type");

        TextView tvBehaviorLabel = findViewById(R.id.tvBehaviorLabel);
        TextView tvRecommendation = findViewById(R.id.tvRecommendation);
        Button btnBack = findViewById(R.id.btnBack);

        String label = petName + " - " + behavior;
        if (subReason != null) label += " / " + subReason;
        tvBehaviorLabel.setText(label);

        BehaviorLogManager manager = BehaviorLogManager.getInstance();
        manager.setPetType(petType);

        BehaviorLog log = new BehaviorLog(petName, behavior, System.currentTimeMillis());
        if (subReason != null) log.setSubReason(subReason);

        String recommendation = manager.logBehavior(log);
        tvRecommendation.setText(recommendation);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}