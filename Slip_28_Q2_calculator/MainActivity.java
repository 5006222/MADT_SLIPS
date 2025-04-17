package com.example.slip3_2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{

    private EditText number1Field;
    private EditText number2Field;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        number1Field=findViewById(R.id.editTextNumber1);
        number2Field=findViewById(R.id.editTextNumber2);
        addButton=findViewById(R.id.buttonAdd);
        subtractButton=findViewById(R.id.buttonSubtract);
        multiplyButton=findViewById(R.id.buttonMultiply);
        divideButton=findViewById(R.id.buttonDivide);
        resultView=findViewById(R.id.textViewResult);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("add");
            }
        });


        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("subtract");
            }
        });


        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("multiply");
            }
        });


        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("divide");
            }
        });
    }

    private void performOperation(String operation) {
        String num1Text = number1Field.getText().toString().trim();
        String num2Text = number2Field.getText().toString().trim();

        if (TextUtils.isEmpty(num1Text) || TextUtils.isEmpty(num2Text)) {
            Toast.makeText(this, "please enter the both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Text);
        double num2 = Double.parseDouble(num2Text);
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "cant divise by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }


        resultView.setText("Result: " + result);
    }

}