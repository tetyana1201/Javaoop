package com.example.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BasicConceptsActivity extends AppCompatActivity {

    private static final String TAG = "BasicConceptsActivity";

    private ImageView checkmarkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_concepts);

        checkmarkImageView = findViewById(R.id.checkmarkImageView); // Ініціалізовано зображення галочки

        Log.d(TAG, "onCreate: Activity created"); // Додайте лог для відстеження створення активності

        Button theoryButton = findViewById(R.id.theoryButton);
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        checkQuizStatus(); // Перевірити статус тестування при запуску активності

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

    private void checkQuizStatus() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("results").child(userId);
            userRef.child("quizStatus").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                    String status = dataSnapshot.getValue(String.class);
                    if ("пройдено".equals(status)) {
                        showCheckmark();
                    } else {
                        hideCheckmark();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e(TAG, "Помилка при отриманні статусу тестування: " + databaseError.getMessage());
                }
            });
        } else {
            Log.e(TAG, "Користувач не автентифікований");
        }
    }

    private void showCheckmark() {
        checkmarkImageView.setVisibility(View.VISIBLE);
    }

    private void hideCheckmark() {
        checkmarkImageView.setVisibility(View.GONE);
    }
}