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

public class TheoryActivitystrings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activitystrings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Рядки");

        TextView textstringsView = findViewById(R.id.textstringsView);
        displayTheory(textstringsView);
    }

    private void displayTheory(TextView textstringsView) {
        String theorystringsText = "Рядки" + "\n" +
                "Для роботи з рядками в Java є класи String та StringBuilder, які надають ряд методів для маніпуляції рядками." + "\n" +
                "Методи класу String" +"\n" +
                "toUpperCase() тa toLowerCase()" + "\n" +
                "Методи переводять усі символи рядку у верхній або нижній регістр." +"\n" +
                "toCharArray()" + "\n" +
                "Метод створює новий масив та копіює кожен наступний символ рядку в елемент масиву.\n" +
                "indexOf(char targetChar)" + "\n" +
                "Метод повертає індекс, під яким символ уперше зʼявляється в рядку.\n" +
                "length()" + "\n" +
                "Метод повертає довжину рядку." + "\n" +
                "isEmpty()" + "\n" +
                "Метод повертає true, коли довжина рядку дорівнює 0. В іншому випадку, метод поверне false.\n" +
                "Методи класу StringBuilder"+ "\n" +
                "Клас StringBuilder використовується для створення рядків символів, які часто змінюються Рекомендуємо використовувати клас StringBuilder обʼєднання рядків, замість + ." + "\n" +
                "append()" + "\n" +
                "Метод конкатенує дане значення рядку до поточного. append () можна викликати послідовно декілька разів. Цей метод приймає типи boolean , char, int, long, String тощо." + "\n" +
                "reverse()" + "\n" +
                "Метод замінює поточне значення рядку на його дзеркальне відображення (зворотню послідовність символів)." + "\n" +
                "toString()" + "\n" +
                "Метод повертає рядок, що представляє поточне значення. Цей метод може бути корисним, коли ти працюєш із рядком StringBuilder , але тип значення, що\n" +
                "повертається з методу - String." + "\n" +
                "Arrays.toString()" + "\n" +
                "Метод Arrays.toString() використовується для перетворення масиву в рядок, де кожен елемент масиву розділяється комою.";


        SpannableString spannableString = new SpannableString(theorystringsText);

        String[] words = {"Рядки", "Методи класу String", "toUpperCase() тa toLowerCase()", "toCharArray()", "indexOf(char targetChar)", "length()", "isEmpty()", "Методи класу StringBuilder", "append()", "reverse()", "toString()", "Arrays.toString()"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, true, true, true, true, true, true, true, true, true, true, true}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {true, true, true, true, true, true, true, true, true, true, true, true}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theorystringsText.indexOf(words[i]);
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
                Log.e("TheoryActivitystrings", "Слово не знайдено: " + words[i]);
            }
        }

        textstringsView.setText(spannableString);
    }
}

