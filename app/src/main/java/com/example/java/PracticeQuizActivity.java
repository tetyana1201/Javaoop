package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeQuizActivity extends AppCompatActivity {

    private static final String TAG = "PracticeQuizActivity";

    private DatabaseReference databaseReference;
    private List<Test> testList;
    private int currentQuestionIndex = 0;

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;
    private List<String> selectedAnswersList = new ArrayList<>(); // Зберігає обрані відповіді для кожного питання
    private List<Integer> selectedQuestionIndexes = new ArrayList<>(); // Зберігає індекси питань, для яких було обрано відповідь


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_quiz);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("tests");

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);

        loadTestsFromFirebase();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId == -1) {
                    Toast.makeText(PracticeQuizActivity.this, "Будь ласка, оберіть відповідь", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedOption = findViewById(selectedOptionId);
                String selectedAnswer = selectedOption.getText().toString();
                selectedAnswersList.add(selectedAnswer); // Додано обрану відповідь до списку
                selectedQuestionIndexes.add(currentQuestionIndex); // Зберігаємо індекс поточного питання

                String correctAnswer = testList.get(currentQuestionIndex).getCorrectAnswer();
                if (selectedAnswer.equals(correctAnswer)) {
                    currentQuestionIndex++;
                    showNextQuestion();
                } else {
                    Toast.makeText(PracticeQuizActivity.this, "Неправильна відповідь", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadTestsFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                testList = new ArrayList<>();
                for (DataSnapshot testSnapshot : dataSnapshot.getChildren()) {
                    Test test = testSnapshot.getValue(Test.class);
                    testList.add(test);
                }
                if (!testList.isEmpty()) {
                    showNextQuestion();
                } else {
                    Toast.makeText(PracticeQuizActivity.this, "Немає тестів у базі даних", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PracticeQuizActivity.this, "Помилка завантаження тестів: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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

        // Перебір тестів для підрахунку правильних відповідей
        for (int i = 0; i < selectedQuestionIndexes.size(); i++) {
            int questionIndex = selectedQuestionIndexes.get(i);
            String selectedAnswer = selectedAnswersList.get(i);
            String correctAnswer = testList.get(questionIndex).getCorrectAnswer();
            if (selectedAnswer.equals(correctAnswer)) {
                correctAnswersCount++;
            }
        }

        // Обчислення відсотка правильних відповідей
        double scorePercentage = (double) correctAnswersCount / totalQuestions * 100;

        // Збереження результатів у базі даних
        saveTestResultsToFirebase(correctAnswersCount, scorePercentage);

        // Створення діалогового вікна з результатами
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Результати тестування");
        builder.setMessage("Правильних відповідей: " + correctAnswersCount + "/" + totalQuestions +
                "\nВідсоток правильних відповідей: " + String.format("%.2f", scorePercentage) + "%");
        builder.setPositiveButton("Закрити", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                navigateToMainPage();
            }
        });
        builder.show();
    }

    private void navigateToMainPage() {
        finish();
        startActivity(new Intent(this, BasicConceptsActivity.class));
    }
    private void saveTestResultsToFirebase(int correctAnswersCount, double scorePercentage) {
        // Отримання посилання на базу даних Firebase для збереження результатів
        DatabaseReference resultsRef = FirebaseDatabase.getInstance().getReference().child("results");

        // Створення нового об'єкту Result для збереження результатів тестування
        Result result = new Result(correctAnswersCount, scorePercentage);

        // Збереження результатів тестування у базу даних
        resultsRef.push().setValue(result);
    }
}