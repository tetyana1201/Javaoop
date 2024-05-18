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

public class TheoryActivityoperators extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityoperators);
        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Оператори");

        TextView textoperatorsView = findViewById(R.id.textoperatorsView);
        displayTheory(textoperatorsView);
    }

    private void displayTheory(TextView textoperatorsView) {
        String theoryoperatorsText = "Оператори" + "\n" +
                "Оператори - це спеціальні символи, які виконують певні операції над операндами (змінними), наприклад, додавання або віднімання." + "\n" +
                "Оператор присвоєння" + "\n" +
                "В попередніх розділах ти вже зустрічався з оператором =, за допомогою якого можна присвоїти певне значення змінній, щоб потім його повторно використати. " +"\n" +
                "Арифметичні оператори" + "\n" +
                "Арифметичні оператори використовуються для виконання операцій базової математики: додавання, віднімання, множення та ділення.";

        SpannableString spannableString = new SpannableString(theoryoperatorsText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Оператори", "Оператор присвоєння", "Арифметичні оператори"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, true, true}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, false, false}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theoryoperatorsText.indexOf(words[i]);
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
                Log.e("TheoryActivityoperators", "Word not found: " + words[i]); // Додайте журнал для відстеження проблеми
            }
        }

        textoperatorsView.setText(spannableString);
    }
}


