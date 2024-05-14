package com.example.java;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
        Button theoryoperatorsButton = findViewById(R.id.theoryoperatorsButton);
        theoryoperatorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityoperators();
            }
        });
    }

    private void openTheoryActivityoperators() {
        Intent intent = new Intent(this, TheoryActivityoperators.class);
        startActivity(intent);
    }
}