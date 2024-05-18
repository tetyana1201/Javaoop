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
                final String emailTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (emailTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Login.this, "Будь ласка, введіть електронну пошту та пароль", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(emailTxt, passwordTxt)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Успішний вхід, відкриваємо MainActivity
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                        finish();
                                        // Сповіщення про успішний вхід
                                        Toast.makeText(Login.this, "Успішний вхід!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // Помилка входу
                                        String errorMessage = task.getException().getMessage();
                                        String translatedMessage = translateFirebaseErrorMessage(errorMessage);
                                        Toast.makeText(Login.this, translatedMessage, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    private String translateFirebaseErrorMessage(String errorMessage) {
        if (errorMessage.contains("The email address is badly formatted.")) {
            return "Неправильний формат електронної пошти.";
        } else if (errorMessage.contains("The email address is already in use by another account")) {
            return "Електронна пошта вже використовується";
        } else if (errorMessage.contains("The password is invalid or the user does not have a password")) {
            return "Неправильний пароль або користувач не має пароля";
        } else if (errorMessage.contains("There is no user record corresponding to this identifier")) {
            return "Користувача з таким ідентифікатором не існує";
        } else if (errorMessage.contains("The password must be 6 characters long or more")) {
            return "Пароль має містити не менше 6 символів";
        } else if (errorMessage.contains("The given password is invalid")) {
            return "Вказано неправильний пароль";
        } else if (errorMessage.contains("The supplied auth credential is incorrect, malformed or has expired.")) {
            return "Надані облікові дані автентифікації неправильні.";
        } else {
            return "Помилка входу: " + errorMessage;
        }
    }
}