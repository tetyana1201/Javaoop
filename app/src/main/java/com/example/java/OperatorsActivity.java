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

public class OperatorsActivity extends AppCompatActivity {
    private static final String TAG = "OperatorsActivity";
    private ImageView checkmarkoperatorsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
        Button theoryoperatorsButton = findViewById(R.id.theoryoperatorsButton);

        checkmarkoperatorsImageView = findViewById(R.id.checkmarkoperatorsImageView);

        Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        // Uncomment the following line if checkQuizStatus method is necessary
        // checkQuizStatus();
        theoryoperatorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivityoperators();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openOperatorsQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openOperatorsPracticeActivity();
            }
        });
    }

    private void openTheoryActivityoperators() {
        Intent intent = new Intent(this, TheoryActivityoperators.class);
        startActivity(intent);
    }

    private void openOperatorsQuizActivity() {
        Intent intent = new Intent(this, OperatorsQuizActivity.class);
        startActivity(intent);
    }

    private void openOperatorsPracticeActivity() {
        Intent intent = new Intent(this, OperatorsPracticeActivity.class);
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
        checkmarkoperatorsImageView.setVisibility(View.VISIBLE);
    }

    private void hideCheckmark() {
        checkmarkoperatorsImageView.setVisibility(View.GONE);
    }
}