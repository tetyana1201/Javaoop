package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StringsActivity extends AppCompatActivity {
    private static final String TAG = "StringsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings);
        // Uncomment the following line if checkmarkImageView is necessary
        // ImageView checkmarkImageView = findViewById(R.id.checkmarkImageView);

        // Uncomment the following line for logging
        // Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        Button theorystringsButton = findViewById(R.id.theorystringsButton);
        theorystringsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivitystrings();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openStringsQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openStringsPracticeActivity();
            }
        });
    }

    private void openTheoryActivitystrings() {
        Intent intent = new Intent(this, TheoryActivitystrings.class);
        startActivity(intent);
    }
    private void openStringsQuizActivity() {
        Intent intent = new Intent(this, StringsQuizActivity.class); // Corrected class name
        startActivity(intent);
    }

    private void openStringsPracticeActivity() {
        Intent intent = new Intent(this, StringsPracticeActivity.class); // Corrected class name
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
