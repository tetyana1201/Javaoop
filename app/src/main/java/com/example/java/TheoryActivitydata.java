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

public class TheoryActivitydata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activitydata);
        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Типи даних");

        TextView textdataView = findViewById(R.id.textdataView);
        displayTheory(textdataView);
    }

    private void displayTheory(TextView textdataView) {
        String theorydataText = "Типи даних" + "\n" +
                "Тип даних визначає операції, які можна виконувати зі змінною та які значення можна в ній зберігати." + "\n" +
                "Примітивні:" + "\n" +
                "Єдиною функцією змінних з примітивним типом даних є зберігання певного значення, наприклад, -5 чи 110. " + "\n" +
                "Примітивні типи даних можна розділити на чотири групи:" + "\n" +
                "  • Цілі числа (integer) - byte, short, int тa long. Відрізняються між собою лише діапазоном значення, який можуть вмістити. Найчастіше використовується тип int." +"\n" +
                "  • Числа з плаваючою крапкою (floating-point) - float і double. Містять число з дробовою часткою і застосовуються для зберігання більш точних даних.\n" +
                "Відрізняються між собою лише діапазоном значення, який можуть вмістити. Найчастіше використовується тип double ." + "\n" +
                "  • Символьні змінні (character) - char. Зберігають лише один символ пунктуації/числа/літери. Значення типу char слід записувати в одинарних лапках, наприклад, '$'." + "\n" +
                "  • Булеві змінні (boolean) - boolean. Зберігає два можливі значення: true (істинне) або false (хибне)." + "\n" +
                "Непримітивні:" + "\n" +
                "Непримітивні типи даних також називають «обʼєктами».\n" +
                "Змінні з таким типом мають власну поведінку та можуть використовувати методи. Представниками непримітивного типу даних є String, який зберігає рядкові дані (послідовність символів)," +
                "а також Array (масив), який являє собою структуру даних, що дозволяє зберігати та упорядковувати кілька значень одного типу під однією назвою." + "\n" +
                "Особливості присвоєння значень змінним\n" +
                "  • для типу long в кінці значення додай літеру l: long a = 5001;\n" +
                "  • для типу float в кінці значення додай літеру f : float f = 0.05f;\n" +
                "  • для типу String обгорни символ або послідовність символів в подвійні лапки \"\": String s = \"А\";";

        SpannableString spannableString = new SpannableString(theorydataText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Типи даних", "Примітивні", "-5;", "110", "(integer)", "(floating-point)","(character)", "(boolean)", "Непримітивні", "Особливості присвоєння значень змінним"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.DKGRAY, Color.DKGRAY}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, true, false, false, false, false, false, false, true, true}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, false, true, true, true, true, true, true, false, false}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theorydataText.indexOf(words[i]);
            int endIndex = startIndex + words[i].length();

            if (startIndex >= 0) { // Перевірка, чи знайдено слово в рядку
                if (bold[i]) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                if (italic[i]) {
                    spannableString.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                spannableString.setSpan(new ForegroundColorSpan(textColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new BackgroundColorSpan(bgColors[i]), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                Log.e("TheoryActivitydata", "Слово не знайдено: " + words[i]);
            }
        }

        textdataView.setText(spannableString);
    }
}
