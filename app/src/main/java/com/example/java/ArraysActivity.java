package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArraysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);
        Button theoryarraysButton = findViewById(R.id.theoryarraysButton);
        theoryarraysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityarrays();
            }
        });
    }

    private void openTheoryActivityarrays() {
        Intent intent = new Intent(this, TheoryActivityarrays.class);
        startActivity(intent);
    }
}