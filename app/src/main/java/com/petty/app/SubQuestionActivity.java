package com.petty.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SubQuestionActivity extends AppCompatActivity {

    private String behavior, petName, petType;
    private boolean showingYesNo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_question);

        behavior = getIntent().getStringExtra("behavior");
        petName = getIntent().getStringExtra("pet_name");
        petType = getIntent().getStringExtra("pet_type");

        showYesNoQuestion();
    }

    private void showYesNoQuestion() {
        TextView tvSubQuestion = findViewById(R.id.tvSubQuestion);
        Button btnOption1 = findViewById(R.id.btnOption1);
        Button btnOption2 = findViewById(R.id.btnOption2);
        Button btnOption3 = findViewById(R.id.btnOption3);
        Button btnOption4 = findViewById(R.id.btnOption4);

        if (behavior.equals("Hasta/Halsiz")) {
            tvSubQuestion.setText("Halsizliğine yol açabilecek bir sebep var mı?");
            btnOption1.setText("Evet");
            btnOption2.setText("Hayır");
            btnOption3.setVisibility(View.GONE);
            btnOption4.setVisibility(View.GONE);

            btnOption1.setOnClickListener(v -> showSubReasonQuestion());
            btnOption2.setOnClickListener(v -> openRecommendation(null));

        } else if (behavior.equals("Kızgın/Huysuz")) {
            tvSubQuestion.setText("Neden kaynaklanıyor?");
            btnOption1.setText("Stres/Korku");
            btnOption2.setText("Aşırı Uyarılma");
            btnOption3.setText("Ağrı/Hastalık");
            btnOption4.setVisibility(View.GONE);

            btnOption1.setOnClickListener(v -> openRecommendation("Stres/Korku"));
            btnOption2.setOnClickListener(v -> openRecommendation("Aşırı Uyarılma"));
            btnOption3.setOnClickListener(v -> openRecommendation("Ağrı/Hastalık"));
        }
    }

    private void showSubReasonQuestion() {
        TextView tvSubQuestion = findViewById(R.id.tvSubQuestion);
        Button btnOption1 = findViewById(R.id.btnOption1);
        Button btnOption2 = findViewById(R.id.btnOption2);
        Button btnOption3 = findViewById(R.id.btnOption3);
        Button btnOption4 = findViewById(R.id.btnOption4);

        tvSubQuestion.setText("Hangisi olabilir?");
        btnOption1.setText("Sindirimsel Sebepler");
        btnOption2.setText("Stres");
        btnOption3.setVisibility(View.VISIBLE);
        btnOption3.setText("Yaralanma");
        btnOption4.setVisibility(View.VISIBLE);
        btnOption4.setText("Enfeksiyon");

        btnOption1.setOnClickListener(v -> openRecommendation("Sindirimsel"));
        btnOption2.setOnClickListener(v -> openRecommendation("Stres"));
        btnOption3.setOnClickListener(v -> openRecommendation("Yaralanma"));
        btnOption4.setOnClickListener(v -> openRecommendation("Enfeksiyon"));
    }

    private void openRecommendation(String subReason) {
        Intent intent = new Intent(this, RecommendationActivity.class);
        intent.putExtra("behavior", behavior);
        intent.putExtra("sub_reason", subReason);
        intent.putExtra("pet_name", petName);
        intent.putExtra("pet_type", petType);
        startActivity(intent);
    }
}