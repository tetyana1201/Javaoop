package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StringsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings);
        Button theorystringsButton = findViewById(R.id.theorystringsButton);
        theorystringsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivitystrings();
            }
        });
    }

    private void openTheoryActivitystrings() {
        Intent intent = new Intent(this, TheoryActivitystrings.class);
        startActivity(intent);
    }
}