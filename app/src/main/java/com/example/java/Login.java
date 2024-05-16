package com.example.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        final EditText email = findViewById(R.id.email);

        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phoneTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (phoneTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Login.this, "Будь ласка, введіть свій номер телефону або пароль", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(phoneTxt, passwordTxt)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Успішний вхід, відкриваємо MainActivity
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                        finish();
                                    } else {
                                        // Помилка входу
                                        Toast.makeText(Login.this, "Помилка входу: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Відкриваємо активність реєстрації
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}
