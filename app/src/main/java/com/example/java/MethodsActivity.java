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

public class MethodsActivity extends AppCompatActivity {

    private static final String TAG = "MethodsActivity";
    private ImageView checkmarkmethodsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods);
        checkmarkmethodsImageView = findViewById(R.id.checkmarkmethodsImageView);

        Log.d(TAG, "onCreate: Activity created");
        Button quizButton = findViewById(R.id.quizButton);
        Button practiceButton = findViewById(R.id.practiceButton);

        checkQuizStatus();
        Button theorymethodsButton = findViewById(R.id.theorymethodsButton);
        theorymethodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheoryActivitymethods();
            }
        });
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Quiz button clicked");
                openMethodsQuizActivity();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Practice button clicked");
                openMethodsPracticeActivity();
            }
        });
    }

    private void openTheoryActivitymethods() {
        Intent intent = new Intent(this, TheoryActivitymethods.class);
        startActivity(intent);
    }
    private void openMethodsQuizActivity() {
        Intent intent = new Intent(this, MethodsQuizActivity.class);
        startActivity(intent);
    }

    private void openMethodsPracticeActivity() {
        Intent intent = new Intent(this, MethodsPracticeActivity.class);
        startActivity(intent);
    }

    private void checkQuizStatus() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("methodsresults").child(userId);
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

        checkmarkmethodsImageView.setVisibility(View.VISIBLE);
    }

    private void hideCheckmark() {

        checkmarkmethodsImageView.setVisibility(View.GONE);
    }
}