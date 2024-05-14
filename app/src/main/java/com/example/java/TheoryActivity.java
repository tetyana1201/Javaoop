package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import android.graphics.Color;

public class TheoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Основні поняття");

        TextView textView = findViewById(R.id.textView);
        displayTheory(textView);
    }

    private void displayTheory(TextView textView) {
        String theoryText = "Змінні" + "\n" +
                "Змінна - це контейнер, який зберігає дані. Ти можеш уявити її як коробку, в яку можна покласти предмет, потім дістати і покласти новий." + "\n" +
                "Наприклад:" + "\n" +
                "  int a = 5;" + "\n" +
                "Де:" + "\n" +
                "  • type - це один із типів даних Java, наприклад, int , String або інший;\n" +
                "  • name - це назва змінної, наприклад, firstName або LastName ;\n" +
                "  • value - це значення змінної.";

        SpannableString spannableString = new SpannableString(theoryText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Змінні", "Змінна", "type", "name", "value", "int a = 5;"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.MAGENTA}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW}; //колір фону
        boolean[] bold = {true, false, false, false, false, false}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, true, true, true, true, false}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theoryText.indexOf(words[i]);
            int endIndex = startIndex + words[i].length();

            if (bold[i]) {
                spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            if (italic[i]) {
                spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            spannableString.setSpan(new ForegroundColorSpan(textColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new BackgroundColorSpan(bgColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        textView.setText(spannableString);


    }
}
