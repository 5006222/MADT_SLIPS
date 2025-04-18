package com.example.slip6_17_q1;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        txtResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSub.setOnClickListener(view -> calculate('-'));
        btnMul.setOnClickListener(view -> calculate('*'));
        btnDiv.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        String str1 = num1.getText().toString();
        String str2 = num2.getText().toString();

        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        double result = 0;

        switch (operator) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = a / b;
                break;
        }

        txtResult.setText("Result: " + result);
    }
}
