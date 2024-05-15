package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BasicConceptsActivity extends AppCompatActivity {

    private static final String TAG = "BasicConceptsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_concepts);

        Log.d(TAG, "onCreate: Activity created"); // Додайте лог для відстеження створення активності

        Button theoryButton = findViewById(R.id.theoryButton);
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        theoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Theory button clicked"); // Додайте лог для відстеження натискання кнопки "Теорія"
                openTheoryActivity();
            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked"); // Додайте лог для відстеження натискання кнопки "Quiz"
                openQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked"); // Додайте лог для відстеження натискання кнопки "Практика"
                openPracticeQuizActivity();
            }
        });
    }

    private void openTheoryActivity() {
        Intent intent = new Intent(this, TheoryActivity.class);
        startActivity(intent);
    }

    private void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    private void openPracticeQuizActivity() {
        Intent intent = new Intent(this, PracticeQuizActivity.class);
        startActivity(intent);
    }
}
