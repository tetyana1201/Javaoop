package com.example.java;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import com.google.firebase.database.ValueEventListener;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class MethodsPracticeActivity extends AppCompatActivity {

    private static final String TAG = "MethodsPracticeActivity";

    private DatabaseReference databaseReference;
    private List<Test> testList;
    private int currentQuestionIndex = 0;

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;
    private List<String> selectedAnswersList = new ArrayList<>();
    private List<Integer> selectedQuestionIndexes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methods_practice);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("methodstests");

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);

        loadTestsFromFirebase();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId == -1) {
                    Toast.makeText(MethodsPracticeActivity.this, "Будь ласка, оберіть відповідь", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedOption = findViewById(selectedOptionId);
                String selectedAnswer = selectedOption.getText().toString();
                selectedAnswersList.add(selectedAnswer);
                selectedQuestionIndexes.add(currentQuestionIndex);

                String correctAnswer = testList.get(currentQuestionIndex).getCorrectAnswer();
                if (selectedAnswer.equals(correctAnswer)) {
                    currentQuestionIndex++;
                    showNextQuestion();
                } else {
                    Toast.makeText(MethodsPracticeActivity.this, "Неправильна відповідь", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadTestsFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                testList = new ArrayList<>();
                for (com.google.firebase.database.DataSnapshot testSnapshot : dataSnapshot.getChildren()) {
                    Test test = testSnapshot.getValue(Test.class);
                    testList.add(test);
                }
                if (!testList.isEmpty()) {
                    showNextQuestion();
                } else {
                    Toast.makeText(MethodsPracticeActivity.this, "Немає тестів у базі даних", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MethodsPracticeActivity.this, "Помилка завантаження тестів: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "loadTestsFromFirebase: Помилка завантаження тестів", databaseError.toException());
            }
        });
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < testList.size()) {
            Test nextQuestion = testList.get(currentQuestionIndex);
            questionTextView.setText(nextQuestion.getQuestion());
            optionsRadioGroup.clearCheck();

            RadioButton[] optionRadioButtons = new RadioButton[]{
                    findViewById(R.id.option1RadioButton),
                    findViewById(R.id.option2RadioButton),
                    findViewById(R.id.option3RadioButton),
                    findViewById(R.id.option4RadioButton)
            };
            List<String> options = Arrays.asList(nextQuestion.getOption1(), nextQuestion.getOption2(), nextQuestion.getOption3(), nextQuestion.getOption4());
            for (int i = 0; i < options.size(); i++) {
                optionRadioButtons[i].setText(options.get(i));
            }
        } else {
            showQuizResults();
        }
    }

    private void showQuizResults() {
        int correctAnswersCount = 0;
        int totalQuestions = testList.size();

        for (int i = 0; i < selectedQuestionIndexes.size(); i++) {
            int questionIndex = selectedQuestionIndexes.get(i);
            String selectedAnswer = selectedAnswersList.get(i);
            String correctAnswer = testList.get(questionIndex).getCorrectAnswer();
            if (selectedAnswer.equals(correctAnswer)) {
                correctAnswersCount++;
            }
        }

        double scorePercentage = (double) correctAnswersCount / totalQuestions * 100;

        saveTestResultsToFirebase(correctAnswersCount, scorePercentage);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Результати тестування");
        builder.setMessage("Правильних відповідей: " + correctAnswersCount + "/" + totalQuestions +
                "\nВідсоток правильних відповідей: " + String.format("%.2f", scorePercentage) + "%");
        builder.setPositiveButton("Закрити", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                updateQuizStatusForCurrentUser();
                navigateToMainPage();
            }
        });
        builder.show();
    }

    private void updateQuizStatusForCurrentUser() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("methodsresults").child(userId);
            userRef.child("quizStatus").setValue("пройдено", new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@NonNull DatabaseError error, @NonNull DatabaseReference ref) {
                    if (error == null) {
                        Log.d(TAG, "Статус тестування оновлено успішно");
                    } else {
                        Log.e(TAG, "Помилка при оновленні статусу тестування: " + error.getMessage());
                    }
                }
            });
        } else {
            Log.e(TAG, "Користувач не автентифікований");
        }
    }

    private void navigateToMainPage() {
        finish();
    }

    private void saveTestResultsToFirebase(int correctAnswersCount, double scorePercentage) {
        DatabaseReference resultsRef = FirebaseDatabase.getInstance().getReference().child("methodsresults");
        Result result = new Result(correctAnswersCount, scorePercentage);
        resultsRef.push().setValue(result);
    }
}
