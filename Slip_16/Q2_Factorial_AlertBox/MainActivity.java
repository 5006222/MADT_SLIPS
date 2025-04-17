package com.example.slip16_2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputNumber;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(view -> {
            String input = inputNumber.getText().toString();
            if (input.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
            } else {
                int number = Integer.parseInt(input);
                long factorialResult = calculateFactorial(number);
                showFactorialDialog(factorialResult);
            }
        });
    }

    // Function to calculate the factorial of a number
    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Function to show the result in an Alert Dialog
    private void showFactorialDialog(long factorial) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Factorial Result");
        builder.setMessage("The factorial is: " + factorial);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
