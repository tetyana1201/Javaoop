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

        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Методи");

        // Отримуємо посилання на TextView
        TextView textmethodsView = findViewById(R.id.textmethodsView);
        displayTheory(textmethodsView);
    }

    private void displayTheory(TextView textmethodsView) {
        String theorymethodsText = "Методи" + "\n" +
                "Що таке метод" + "\n" +
                "Метод - це блок коду, створений для виконання певного завдання або операції. Метод може приймати вхідні\n" +
                "параметри та повертати якийсь результат. Один метод може виконуватися багато разів із різними вхідними даними." +"\n" +
                "Базовими прикладами є методи обчислення площі прямокутника або підрахунку відсотків по кредиту: код залишається незмінним, а вхідні дані кожен раз підставляються динамічно." + "\n" +
                "Використання методів вкрай важливе в програмуванні, адже вони забезпечують повторне використання коду: ти напишеш метод один раз, а використовувати ти можеш\n" +
                "скільки завгодно разів. Крім того, ти можеш розділити обʼємну задачу на декілька простих, кожну з яких буде виконувати окремий метод." +"\n" +
                "Тип результату" + "\n" +
                "Важливо розуміти, що є результатом роботи методу (іншими словами, що твій метод поверне в результаті виконання) — рядок, ціле чи дробове число. Тому при оголошенні методу ми повинні явно вказати, якого типу буде значення, що повертається внаслідок роботи методу.\n" +
                "Назва методу" + "\n" +
                "Методів у твоїй програмі може бути багато, тому Java має розуміти, який саме обрати в тому, чи іншому випадку. Для цього використовується назва методу.\n" +
                "Тіло методу" + "\n" +
                "Тіло методу - це код, який виконується для здійснення необхідних операцій. Тіло методу розташовано у фігурних дужках { } ." + "\n" +
                "Виклик методу" + "\n" +
                "Щоб викликати метод у мові Java, потрібно написати імʼя методу, а потім підставити в дужки вхідні параметри (якщо вони є).\n" +
                "Не забувай у кінці рядку ставити ; ."+ "\n" +
                "Ключове слово return y void методах" + "\n" +
                "Ти можеш використовувати ключове слово return В методах, які не повертають значення. У цьому випадку програма виходить із методу в точці, де викликається return . Після виклику return решта коду методу\n" +
                "виконана не буде.";

        SpannableString spannableString = new SpannableString(theorymethodsText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Методи", "Що таке метод", "Тип результату", "Назва методу", "Тіло методу", "Виклик методу", "Ключове слово return y void методах"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, true, true, true, true, true, true}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {true, true, true, true, true, true, true}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theorymethodsText.indexOf(words[i]);
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
                Log.e("TheoryActivityloops", "Word not found: " + words[i]); // Додайте журнал для відстеження проблеми
            }
        }

        textmethodsView.setText(spannableString);
    }
}

