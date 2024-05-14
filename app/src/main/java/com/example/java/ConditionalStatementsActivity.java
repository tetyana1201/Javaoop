package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ConditionalStatementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditional_statements);
        Button theoryconditionalButton = findViewById(R.id.theoryconditionalButton);
        theoryconditionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityconditional();
            }
        });
    }

    private void openTheoryActivityconditional() {
        Intent intent = new Intent(this, TheoryActivityconditional.class);
        startActivity(intent);
    }
}