package com.petty.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    private String selectedPetType = "";
    private Button btnCat, btnDog, btnContinue;
    private EditText etPetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        btnCat = findViewById(R.id.btnCat);
        btnDog = findViewById(R.id.btnDog);
        btnContinue = findViewById(R.id.btnContinue);
        etPetName = findViewById(R.id.etPetName);

        btnCat.setOnClickListener(v -> {
            selectedPetType = "cat";
            btnCat.setBackgroundTintList(getColorStateList(R.color.selected_button));
            btnDog.setBackgroundTintList(getColorStateList(R.color.unselected_button));
        });

        btnDog.setOnClickListener(v -> {
            selectedPetType = "dog";
            btnDog.setBackgroundTintList(getColorStateList(R.color.selected_button));
            btnCat.setBackgroundTintList(getColorStateList(R.color.unselected_button));
        });

        btnContinue.setOnClickListener(v -> {
            String petName = etPetName.getText().toString().trim();
            if (selectedPetType.isEmpty()) {
                Toast.makeText(this, "Lutfen bir hayvan secin!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (petName.isEmpty()) {
                Toast.makeText(this, "Lutfen hayvaninizin adini girin!", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences prefs = getSharedPreferences("petty_prefs", MODE_PRIVATE);
            prefs.edit()
                    .putString("pet_type", selectedPetType)
                    .putString("pet_name", petName)
                    .apply();

            startActivity(new Intent(this, HomeActivity.class));
            finish();
        });
    }
}