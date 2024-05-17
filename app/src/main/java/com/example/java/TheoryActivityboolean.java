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
                "  •  < перевіряє, чи значення справа більше за значення зліва." + "\n" +
                "Непримітивні:" + "\n" +
                "Непримітивні типи даних також називають «обʼєктами».\n" +
                "Змінні з таким типом мають власну поведінку та можуть використовувати методи. Представниками непримітивного типу даних є String, який зберігає рядкові дані (послідовність символів)," +
                "а також Array (масив), який являє собою структуру даних, що дозволяє зберігати та упорядковувати кілька значень одного типу під однією назвою." + "\n" +
                "Особливості присвоєння значень змінним\n" +
                "  • для типу long в кінці значення додай літеру l: long a = 5001;\n" +
                "  • для типу float в кінці значення додай літеру f : float f = 0.05f;\n" +
                "  • для типу String обгорни символ або послідовність символів в подвійні лапки \"\": String s = \"А\";";

        SpannableString spannableString = new SpannableString(theorybooleanText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Оператори порівняння", "true", "false", "==", "!=", ">","<"};
        int[] textColors = {Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW}; //колір фону
        boolean[] bold = {true, false, false, false, false, false, false}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, true, true, true, true, true, true}; // курсив

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
                Log.e("TheoryActivitydata", "Word not found: " + words[i]); // Додайте журнал для відстеження проблеми
            }
        }

        textbooleanView.setText(spannableString);
    }
}

