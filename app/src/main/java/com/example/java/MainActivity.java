package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        displayTheory(textView);


        Button javaBaseButton = findViewById(R.id.javaBaseButton);
        javaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJavaBase();
            }
        });

        ImageView logoutImageView = findViewById(R.id.logoutImageView);
        logoutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    private void displayTheory(TextView textView) {
        String theoryText = "Привіт! Вітаємо тебе на курсі." + "\n" +
                "Java - це мова програмування," + "\n" +
                "за допомогою якої можна" + "\n" +
                "розробляти ігри, мобільні" + "\n" +
                "додатки, вебдодатки."+ "\n" +
                "Перейти до вивчення:";

        SpannableString spannableString = new SpannableString(theoryText);

        // Кольори тексту та фону, жирний та курсив
        String[] words = {"Java", "Перейти до вивчення:"};
        int[] textColors = {Color.DKGRAY, Color.BLACK}; //колір тексту
        int[] bgColors = {Color.TRANSPARENT, Color.TRANSPARENT}; //колір фону
        boolean[] bold = {true, false}; // жирний TRANSPARENT-прозорий
        boolean[] italic = {false, true}; // курсив

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

    public void openJavaBase() {
        Intent intent = new Intent(this, JavaBase.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
