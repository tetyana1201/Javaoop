package com.example.java;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class MethodsQuizActivity extends AppCompatActivity {
    private EditText questionEditText, option1EditText, option2EditText, option3EditText, option4EditText, correctAnswerEditText;
    private Button addButton;

    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods_quiz);

        questionEditText = findViewById(R.id.questionEditText);
        option1EditText = findViewById(R.id.option1EditText);
        option2EditText = findViewById(R.id.option2EditText);
        option3EditText = findViewById(R.id.option3EditText);
        option4EditText = findViewById(R.id.option4EditText);
        correctAnswerEditText = findViewById(R.id.correctAnswerEditText);
        addButton = findViewById(R.id.addButton);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            String currentUserID = user.getUid();
            Log.d("CurrentUserID", currentUserID);
            if (currentUserID.equals("Nd2M1lgHunVWFtq2Z7HFaqLdAzR2")) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("methodstests");
                addButton.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MethodsQuizActivity.this, "Ви не маєте прав доступу", Toast.LENGTH_SHORT).show();
                addButton.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(MethodsQuizActivity.this, "Поточний користувач не знайдений", Toast.LENGTH_SHORT).show();
            addButton.setVisibility(View.GONE);
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questionEditText.getText().toString();
                String option1 = option1EditText.getText().toString();
                String option2 = option2EditText.getText().toString();
                String option3 = option3EditText.getText().toString();
                String option4 = option4EditText.getText().toString();
                String correctAnswer = correctAnswerEditText.getText().toString();

                Test test = new Test(question, option1, option2, option3, option4, correctAnswer);

                // Додаємо тест до Firebase
                databaseReference.push().setValue(test, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@NonNull DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) {
                            Toast.makeText(MethodsQuizActivity.this, "Тест успішно додано", Toast.LENGTH_SHORT).show();
                            // Перенаправлення на головну сторінку після успішного додавання
                            navigateToMainPage();
                        } else {
                            Toast.makeText(MethodsQuizActivity.this, "Не вдалося додати тест", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    // Метод для перенаправлення на головну сторінку (BasicConceptsActivity)
    private void navigateToMainPage() {
        finish(); // Закрити поточну активність (QuizActivity)
    }
}
