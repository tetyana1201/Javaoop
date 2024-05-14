package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);
        Button theoryloopsButton = findViewById(R.id.theoryloopsButton);
        theoryloopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityloops();
            }
        });
    }

    private void openTheoryActivityloops() {
        Intent intent = new Intent(this, TheoryActivityloops.class);
        startActivity(intent);
    }
}