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

public class TheoryActivityboolean extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityboolean);
        // Отримуємо посилання на Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Встановлюємо текст на Toolbar
        toolbar.setTitle("Булеві операції");

        TextView textbooleanView = findViewById(R.id.textbooleanView);
        displayTheory(textbooleanView);
    }

    private void displayTheory(TextView textbooleanView) {
        String theorybooleanText = "Оператори порівняння" + "\n" +
                "Одним із частих завдань у програмуванні є порівняння чисел між собою:" + "\n" +
                "  • true - якщо дані задовільняють умову;" +"\n" +
                "  • false - якщо дані не задовільняють умову.\n" +
                "  • == перевіряє, чи рівні змінні, які були передані." +"\n" +
                "  • != працює протилежно до рівності.\n" +
                "  • > перевіряє, чи значення зліва більше за значення справа." + "\n" +
                "  • < перевіряє, чи значення справа більше за значення зліва." + "\n" +
                "Логічні оператори" + "\n" +
                "Логічні оператори поєднують два (або більше) логічні значення, утворюючи результуюче логічне значення.\n" +
                "У Java доступні такі логічні оператори: &&, II та !».\n" +
                "Логічне AND (&&)" + "\n" +
                "Цей оператор повертає true , коли виконуються обидві умови. Якщо одне з двох тверджень хибне, результат буде дорівнювати false." + "\n" +
                "Логічне OR (II)" + "\n" +
                "Цей оператор повертає true , якщо хоча б одна з двох умов істинна. Якщо два твердження хибні, результат буде дорівнювати false."+ "\n" +
                "Логічне NOT (!)" + "\n" +
                "Цей унарний оператор змінює результат на протилежний і повертає false, якщо результат істинний (і навпаки).";

        SpannableString spannableString = new SpannableString(theorybooleanText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Оператори порівняння", "true", "false", "==", "!=", ">","<", "Логічні оператори", "AND", "OR", "NOT"};
        int[] textColors = {Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW}; //колір фону
        boolean[] bold = {true, false, false, false, false, false, false, true, false, false, false}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, true, true, true, true, true, true, false, true, true, true}; // курсив

        for (int i = 0; i < words.length; i++) {
            int startIndex = theorybooleanText.indexOf(words[i]);
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
                Log.e("TheoryActivityboolean", "Слово не знайдено: " + words[i]);
            }
        }

        textbooleanView.setText(spannableString);
    }
}

