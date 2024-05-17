package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class ConditionalStatementsActivity extends AppCompatActivity {
    private static final String TAG = "ConditionalStatementsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditional_statements);
        // Uncomment the following line if checkmarkImageView is necessary
        // ImageView checkmarkImageView = findViewById(R.id.checkmarkImageView);

        // Uncomment the following line for logging
        // Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        Button theoryconditionalButton = findViewById(R.id.theoryconditionalButton);
        theoryconditionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityconditional();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openConditionalQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openConditionalPracticeActivity();
            }
        });
    }

    private void openTheoryActivityconditional() {
        Intent intent = new Intent(this, TheoryActivityconditional.class);
        startActivity(intent);
    }
    private void openConditionalQuizActivity() {
        Intent intent = new Intent(this, CondionalQuizActivity.class); // Corrected class name
        startActivity(intent);
    }

    private void openConditionalPracticeActivity() {
        Intent intent = new Intent(this, CondionalPracticeActivity.class); // Corrected class name
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
