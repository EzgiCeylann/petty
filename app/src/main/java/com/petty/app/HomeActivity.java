package com.petty.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private String petName, petType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences prefs = getSharedPreferences("petty_prefs", MODE_PRIVATE);
        petName = prefs.getString("pet_name", "Dostun");
        petType = prefs.getString("pet_type", "cat");

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        TextView tvQuestion = findViewById(R.id.tvQuestion);
        tvGreeting.setText("Hoşgeldin!");
        tvQuestion.setText("Bugün " + petName + " nasıl?");

        Button btnTired = findViewById(R.id.btnTired);
        Button btnSick = findViewById(R.id.btnSick);
        Button btnPlayful = findViewById(R.id.btnPlayful);
        Button btnAngry = findViewById(R.id.btnAngry);
        Button btnHappy = findViewById(R.id.btnHappy);
        Button btnViewReport = findViewById(R.id.btnViewReport);

        btnTired.setOnClickListener(v -> openQuestion("Yorgun", null));
        btnPlayful.setOnClickListener(v -> openQuestion("Oyuncu", null));
        btnHappy.setOnClickListener(v -> openQuestion("Sakin/Mutlu", null));
        btnSick.setOnClickListener(v -> openSubQuestion("Hasta/Halsiz"));
        btnAngry.setOnClickListener(v -> {
            if (petType.equals("dog")) {
                openSubQuestion("Kızgın/Huysuz");
            } else {
                openQuestion("Kızgın/Huysuz", null);
            }
        });

        btnViewReport.setOnClickListener(v ->
                startActivity(new Intent(this, ReportActivity.class))
        );
    }

    private void openQuestion(String behavior, String subReason) {
        Intent intent = new Intent(this, RecommendationActivity.class);
        intent.putExtra("behavior", behavior);
        intent.putExtra("sub_reason", subReason);
        intent.putExtra("pet_name", petName);
        intent.putExtra("pet_type", petType);
        startActivity(intent);
    }

    private void openSubQuestion(String behavior) {
        Intent intent = new Intent(this, SubQuestionActivity.class);
        intent.putExtra("behavior", behavior);
        intent.putExtra("pet_name", petName);
        intent.putExtra("pet_type", petType);
        startActivity(intent);
    }
}