package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoopsActivity extends AppCompatActivity {
    private static final String TAG = "LoopsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);
        // Uncomment the following line if checkmarkImageView is necessary
        // ImageView checkmarkImageView = findViewById(R.id.checkmarkImageView);

        // Uncomment the following line for logging
        // Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        Button theoryloopsButton = findViewById(R.id.theoryloopsButton);
        theoryloopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityloops();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openLoopsQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openLoopsPracticeActivity();
            }
        });
    }

    private void openTheoryActivityloops() {
        Intent intent = new Intent(this, TheoryActivityloops.class);
        startActivity(intent);
    }
    private void openLoopsQuizActivity() {
        Intent intent = new Intent(this, LoopsQuizActivity.class); // Corrected class name
        startActivity(intent);
    }

    private void openLoopsPracticeActivity() {
        Intent intent = new Intent(this, LoopsPracticeActivity.class); // Corrected class name
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
