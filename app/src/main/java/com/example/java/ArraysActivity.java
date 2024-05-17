package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ArraysActivity extends AppCompatActivity {
    private static final String TAG = "ArraysActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays);
        // Uncomment the following line if checkmarkImageView is necessary
        // ImageView checkmarkImageView = findViewById(R.id.checkmarkImageView);

        // Uncomment the following line for logging
        // Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        Button theoryarraysButton = findViewById(R.id.theoryarraysButton);
        theoryarraysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityarrays();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openArraysQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openArraysPracticeActivity();
            }
        });
    }

    private void openTheoryActivityarrays() {
        Intent intent = new Intent(this, TheoryActivityarrays.class);
        startActivity(intent);
    }
    private void openArraysQuizActivity() {
        Intent intent = new Intent(this, ArraysQuizActivity.class); // Corrected class name
        startActivity(intent);
    }

    private void openArraysPracticeActivity() {
        Intent intent = new Intent(this, ArraysPracticeActivity.class); // Corrected class name
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
