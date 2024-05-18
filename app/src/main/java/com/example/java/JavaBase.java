package com.example.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class JavaBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_base);

        Button basicConceptsButton = findViewById(R.id.basicConceptsButton);
        Button dataTypesButton = findViewById(R.id.dataTypesButton);
        Button operatorsButton = findViewById(R.id.operatorsButton);
        Button methodsButton = findViewById(R.id.methodsButton);
        Button booleanOperationsButton = findViewById(R.id.booleanOperationsButton);
        Button conditionalStatementsButton = findViewById(R.id.conditionalStatementsButton);
        Button loopsButton = findViewById(R.id.loopsButton);
        Button arraysButton = findViewById(R.id.arraysButton);
        Button stringsButton = findViewById(R.id.stringsButton);

        basicConceptsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBasicConceptsActivity();
            }
        });

        dataTypesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataTypesActivity();
            }
        });

        operatorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOperatorsActivity();
            }
        });

        methodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMethodsActivity();
            }
        });

        booleanOperationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooleanOperationsActivity();
            }
        });

        conditionalStatementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConditionalStatementsActivity();
            }
        });

        loopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoopsActivity();
            }
        });

        arraysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArraysActivity();
            }
        });

        stringsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStringsActivity();
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

    private void openBasicConceptsActivity() {
        Intent intent = new Intent(this, BasicConceptsActivity.class);
        startActivity(intent);
    }

    private void openDataTypesActivity() {
        Intent intent = new Intent(this, DataTypesActivity.class);
        startActivity(intent);
    }

    private void openOperatorsActivity() {
        Intent intent = new Intent(this, OperatorsActivity.class);
        startActivity(intent);
    }

    private void openMethodsActivity() {
        Intent intent = new Intent(this, MethodsActivity.class);
        startActivity(intent);
    }

    private void openBooleanOperationsActivity() {
        Intent intent = new Intent(this, BooleanOperationsActivity.class);
        startActivity(intent);
    }

    private void openConditionalStatementsActivity() {
        Intent intent = new Intent(this, ConditionalStatementsActivity.class);
        startActivity(intent);
    }

    private void openLoopsActivity() {
        Intent intent = new Intent(this, LoopsActivity.class);
        startActivity(intent);
    }

    private void openArraysActivity() {
        Intent intent = new Intent(this, ArraysActivity.class);
        startActivity(intent);
    }

    private void openStringsActivity() {
        Intent intent = new Intent(this, StringsActivity.class);
        startActivity(intent);
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}