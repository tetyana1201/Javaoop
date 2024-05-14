package com.example.java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button javaBaseButton = findViewById(R.id.javaBaseButton);
        javaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJavaBase();
            }
        });
    }

    public void openJavaBase() {
        Intent intent = new Intent(this, JavaBase.class);
        startActivity(intent);
    }
}

