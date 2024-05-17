package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class BooleanOperationsActivity extends AppCompatActivity {
    private static final String TAG = "BooleanOperationsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolean_operations);
        // Uncomment the following line if checkmarkImageView is necessary
        // ImageView checkmarkImageView = findViewById(R.id.checkmarkImageView);

        // Uncomment the following line for logging
        // Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        Button theorybooleanButton = findViewById(R.id.theorybooleanButton);
        theorybooleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityboolean();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openBooleanQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openBooleanPracticeActivity();
            }
        });
    }

    private void openTheoryActivityboolean() {
        Intent intent = new Intent(this, TheoryActivityboolean.class);
        startActivity(intent);
    }
    private void openBooleanQuizActivity() {
        Intent intent = new Intent(this, BooleanQuizActivity.class); // Corrected class name
        startActivity(intent);
    }

    private void openBooleanPracticeActivity() {
        Intent intent = new Intent(this, BooleanPracticeActivity.class); // Corrected class name
        startActivity(intent);
    }

    // Uncomment the following method if necessary
    /*
    private void checkQuizStatus() {
        // Add your Firebase logic here
    }
    */

    // Uncomment the following methods if necessary
    /*
    private void showCheckmark() {
        // Add your logic to show checkmark
    }

    private void hideCheckmark() {
        // Add your logic to hide checkmark
    }
    */
}
