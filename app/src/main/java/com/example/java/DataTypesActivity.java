package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_types);

        // Оголошуємо кнопку і налаштовуємо обробник кліків всередині методу onCreate()
        Button theorydataButton = findViewById(R.id.theorydataButton);
        theorydataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivitydata();
            }
        });
    }

    private void openTheoryActivitydata() {
        Intent intent = new Intent(this, TheoryActivitydata.class);
        startActivity(intent);
    }
}
