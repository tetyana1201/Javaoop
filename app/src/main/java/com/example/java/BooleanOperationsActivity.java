package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class BooleanOperationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolean_operations);
        Button theorybooleanButton = findViewById(R.id.theorybooleanButton);
        theorybooleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityboolean();
            }
        });
    }

    private void openTheoryActivityboolean() {
        Intent intent = new Intent(this, TheoryActivityboolean.class);
        startActivity(intent);
    }
}