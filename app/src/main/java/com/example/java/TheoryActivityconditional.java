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

public class TheoryActivityconditional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityconditional);

        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Умовні оператори");

        // Отримуємо посилання на TextView
        TextView textconditionalView = findViewById(R.id.textconditionalView);
        displayTheory(textconditionalView);
    }

    private void displayTheory(TextView textconditionalView) {
        String theoryconditionalText = "Умовні оператори" + "\n" +
                "Як ти вже знаєш, команди в програмі виконуються послідовно (згори вниз). Але іноді треба, щоби деякі команди виконувалися тільки за певною умовою: істинною (true ) або не істинною (false ). Для цього використовуються умовні оператори." + "\n" +
                "Оператор if" +"\n" +
                "Якщо ти хочеш перевірити лише одну умову, використовуй оператор if." + "\n" +
                "Якщо тобі потрібно перевірити декілька умов, можна використати оператор іf всередині іншого if.\n" +
                "Оператор else" + "\n" +
                "Іноді треба виконати різні команди, залежно від того, істинна умова, чи ні. Це можна зробити за допомогою двох конструкцій if з протилежними умовами. \n" +
                "Оператор else if" + "\n" +
                "Якщо ти хочеш перевірити виконання понад двох умов, тоді можна використати оператор else if з додатковою умовою.\n" +
                "Ключове слово return всередині if" + "\n" +
                "Якщо if використовується всередині методу, який повертає якесь значення, то можна скористатись\n" +
                "ключовим словом return." + "\n" +
                "Умовний (тернарний) оператор" + "\n" +
                "Іноді потрібно встановити різні значення змінної відповідно до виконаної умови. Це можна зробити, використавши оператори if тa else.";

        SpannableString spannableString = new SpannableString(theoryconditionalText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Умовні оператори", "Оператор if", "Оператор else", "Оператор else if", "Ключове слово return всередині if", "Умовний (тернарний) оператор"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, true, true, true, true, true}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {true, true, true, true, true, true}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theoryconditionalText.indexOf(words[i]);
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
                Log.e("TheoryActivityconditional", "Слово не знайдено: " + words[i]);
            }
        }

        textconditionalView.setText(spannableString);
    }
}

