package com.example.java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        final EditText conPassword = findViewById(R.id.conPassword);
        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.loginNow);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                if (fullnameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(Register.this, "Будь ласка, заповніть усі поля", Toast.LENGTH_SHORT).show();
                } else if (!passwordTxt.equals(conPasswordTxt)) {
                    Toast.makeText(Register.this, "Пароль не збігається", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(emailTxt, passwordTxt)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Користувач успішно зареєстрований
                                        Toast.makeText(Register.this, "Користувач успішно зареєстрований", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        // Виникла помилка при реєстрації користувача
                                        String errorMessage = task.getException().getMessage();
                                        String translatedMessage = translateFirebaseErrorMessage(errorMessage);
                                        Toast.makeText(Register.this, translatedMessage, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String translateFirebaseErrorMessage(String errorMessage) {
        if (errorMessage.contains("The email address is badly formatted")) {
            return "Неправильний формат електронної пошти";
        } else if (errorMessage.contains("The email address is already in use by another account")) {
            return "Електронна пошта вже використовується";
        } else if (errorMessage.contains("The password is invalid or the user does not have a password")) {
            return "Неправильний пароль або користувач не має пароля";
        } else if (errorMessage.contains("There is no user record corresponding to this identifier")) {
            return "Користувача з таким ідентифікатором не існує";
        } else if (errorMessage.contains("The given password is invalid. [ Password should be at least 6 characters ]")) {
            return "Вказано неправильний пароль. Пароль має містити не менше 6 символів";
        } else {
            return "Реєстрація не вдалася: " + errorMessage;
        }
    }
}
