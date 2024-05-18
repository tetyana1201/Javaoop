package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;

public class TheoryActivityloops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityloops);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Цикли");

        TextView textloopsView = findViewById(R.id.textloopsView);
        displayTheory(textloopsView);
    }

    private void displayTheory(TextView textloopsView) {
        String theoryloopsText = "Цикли" + "\n" +
                "Основне завдання циклів - повторне виконання певних інструкцій." + "\n" +
                "Загалом, у мові Java є такі види циклів:" +"\n" +
                "  • for;\n" +
                "  • while;\n" +
                "  • do while;\n" +
                "  • for each.\n" +
                "Цикл for" +"\n" +
                "Використання такого циклу є дуже зручним. Якщо потрібно зменшити кількість повторень, ти просто можеш\n" +
                "змінити умову виконання тіла. Наприклад, при і < 50; ти матимеш удвічі менше повторень." + "\n" +
                "Цикл while" + "\n" +
                "Цикл while можна порівняти з оператором if . Спочатку перевіряємо умову. Якщо вона має значення true, то виконується тіло циклу, а якщо false - цикл завершується." + "\n" +
                "Цикл do while" + "\n" +
                "Він подібний до циклу while з тією лише різницею, що перевіряє умову після виконання тіла циклу. Цикл починає виконання тіла без перевірки будь-яких умов.\n" +
                "Іншими словами, тіло циклу завжди виконається принаймні один раз.\n" +
                "Після виконання тіла умова перевіриться на true бо false . Якщо вона дорівнює true , починається наступна ітерація циклу, якщо false - цикл завершується.";

        SpannableString spannableString = new SpannableString(theoryloopsText);

        String[] words = {"Цикли", "Цикл for", "Цикл while", "Цикл do while"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY};
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT};
        boolean[] bold = {true, true, true, true};
        boolean[] italic = {true, true, true, true};

        for (int i = 0; i < words.length; i++) {
            int startIndex = theoryloopsText.indexOf(words[i]);
            int endIndex = startIndex + words[i].length();

            if (startIndex >= 0) {
                if (bold[i]) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (italic[i]) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                spannableString.setSpan(new ForegroundColorSpan(textColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new BackgroundColorSpan(bgColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                Log.e("TheoryActivityloops", "Слово не знайдено: " + words[i]);
            }
        }

        textloopsView.setText(spannableString);
    }
}

