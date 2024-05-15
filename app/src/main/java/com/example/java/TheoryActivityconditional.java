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
import android.widget.TextView;

public class TheoryActivityconditional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_activityconditional);
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
                "В Java є різні типи змінних:" + "\n" +
                "  • String - зберігає текст, наприклад, \"Hello\" . Рядкові значення беруться в подвійні лапки \"' ;\n" +
                "  • int - зберігає цілі числа без десяткових знаків, наприклад, 123 або -123 ;" + "\n" +
                "  • boolean - зберігає два можливі значення: true (істине) або false (хибне)." + "\n" +
                "Щоб створити змінну, потрібно вказати її тип, назву та присвоїти їй значення:" + "\n" +
                "type name = value;\n" +
                "Де:\n" +
                "  • type - це один із типів даних Java, наприклад, int , String або інший;\n" +
                "  • name - це назва змінної, наприклад, firstName або LastName ;\n" +
                "  • value - це значення змінної.\n" +
                "Назва змінної потрібна для того, щоб отримати значення, яке в ній записано, наприклад, для виведення в консоль - System.out. println (name);\n" +
                "Знак рівності використовується для присвоєння змінній значення.\n" +
                "Зверни увагу: назви змінних потрібно писати англійською мовою. Також рекомендуємо називати змінні в lowerCamelCase.\n" +
                "Наприклад:\n" +
                "String name = \"Bob\";\n" +
                "boolean isMarried = true;\n" +
                "Оголошення та ініціалізація змінної\n" +
                "Важливо розуміти різницю між оголошенням та ініціалізацією змінної.\n" +
                "Оголошення змінної - це процес створення змінної з таким синтаксисом: type variableName.\n" +
                "Ініціалізація змінної - це процес присвоєння значення змінній, яка вже створена.\n" +
                "Зазвичай, оголошення та ініціалізація змінної відбуваються водночас:\n" +
                "int number = 5;\n" +
                "Коментарі\n" +
                "При написанні програми може бути корисним залишати коментарі до коду, який ти пишеш. Коментарі використовуються для того, щоб через деякий час, коли доведеться покращувати або доповнювати наявний код, було простіше розібратись, що відбувається.\n" +
                "Для того, щоб компʼютер проігнорував певні символи та не пробував їх опрацьовувати, тобі потрібно явно вказати про це за допомогою спецсимволів коментування: // , /*\n" +
                "та */. \n" +
                "Є два види коментарів: \n" +
                "Однорядкові коментарі починаються з двох знаків слеш //.\n" +
                "Наприклад:\n" +
                "// Це однорядковий коментар\n" +
                "Багаторядкові коментарі починаються з /* і закінчуються */ .\n" +
                "Наприклад:\n" +
                "/* Це багаторядковий коментар.\n" +
                "Java його проігнорує */\n" +
                "Відображення інформації в консолі\n" +
                "Під час написання програм буде корисним навчитись відображати певну інформацію в консолі (виводити на екран).\n" +
                "В ролі даних, які корисно показати, можуть бути поточні значення змінних або результати різних операцій, наприклад, додавання чи віднімання. Щоб це зробити, потрібно використати конструкцію:\n" +
                "System.out.println (\"Повідомлення\");\n" +
                "Де  \"Повідомлення\" - це будь-який текст, який ти хочеш вивести. Крім тексту, це може бути й інша інформація, наприклад, значення змінної чи число.";

        SpannableString spannableString = new SpannableString(theoryText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Змінні", "Змінна", "int a = 5;", "type name = value;", "System.out. println (name);", "Зверни увагу","String name = \"Bob\";", "boolean isMarried = true;", "Важливо", "Оголошення та ініціалізація змінної", "type variableName", "Коментарі", "Однорядкові", "Багаторядкові","Відображення інформації в консолі","Повідомлення","// Це однорядковий коментар","/* Це багаторядковий коментар.", "Java його проігнорує */"};
        int[] textColors = {Color.DKGRAY, Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.DKGRAY, Color.DKGRAY, Color.MAGENTA, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA, Color.MAGENTA}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.TRANSPARENT, Color.TRANSPARENT, Color.YELLOW, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW}; //колір фону
        boolean[] bold = {true, false, false, false, false, true, false, false, true, true, false, true, true, true, true, false, false, false, false}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}; // курсив

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
