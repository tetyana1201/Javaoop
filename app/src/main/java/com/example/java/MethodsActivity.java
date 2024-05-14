package com.example.java;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MethodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);
        Button theorymethodsButton = findViewById(R.id.theorymethodsButton);
        theorymethodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivitymethods();
            }
        });
    }

    // Метод для відкриття іншої активності
    private void openTheoryActivitymethods() {
        Intent intent = new Intent(this, TheoryActivitymethods.class);
        startActivity(intent);
    }
}