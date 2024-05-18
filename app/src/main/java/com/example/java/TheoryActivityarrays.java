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

public class TheoryActivityarrays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityarrays);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Масиви");

        TextView textarraysView = findViewById(R.id.textarraysView);
        displayTheory(textarraysView);
    }

    private void displayTheory(TextView textarraysView) {
        String theoryarraysText = "Що таке масив" + "\n" +
                "Масив - це набір елементів одного типу. Використовуючи масиви можна спростити роботу з однотипними елементами: після того як ти їх поєднаєш в один масив, ти можеш працювати з масивом як з окремим елементом." + "\n" +
                "Масив може містити елементи лише одного типу даних." +"\n" +
                "Довжина масиву" + "\n" +
                "Довжина масиву - це максимальна кількість елементів, яку він може зберігати. Цю інформацію можна отримати, написавши масив. length, де масив - це назва масиву." +"\n" +
                "Зверни увагу: ти не можеш змінити довжину вже створеного масиву. Це може стати проблемою, якщо в тебе є тільки частина значень масиву, а частину ти хочеш порахувати під час роботи програми. В такому випадку, ти можеш створити пустий масив потрібного розміру, а потім\n" +
                "поетапно його заповнити." + "\n" +
                "Помилка IndexOutOfBoundException" + "\n" +
                "Якщо ти спробуєш отримати або оновити значення елемента за індексом, який не існує, у тебе виникне помилка IndexOutOfBoundException." + "\n" +
                "Цикл for each" + "\n" +
                "Є скорочений спосіб протерувати масив - використати цикл for each ."+ "\n" +
                "Висновок: якщо тобі потрібно оперувати елементами масиву, а індекси не важливі - використай цикл for each. У всіх інших випадках доцільніше використати цикл for.";

        SpannableString spannableString = new SpannableString(theoryarraysText);

        String[] words = {"Що таке масив", "Довжина масиву", "Зверни увагу", "Висновок", "Помилка IndexOutOfBoundException"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY};
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT};
        boolean[] bold = {true, true, true, true, true};
        boolean[] italic = {true, true, true, true, true};

        for (int i = 0; i < words.length; i++) {
            int startIndex = theoryarraysText.indexOf(words[i]);
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
                Log.e("TheoryActivityarrays", "Слово не знайдено: " + words[i]);
            }
        }

        textarraysView.setText(spannableString);
    }
}

