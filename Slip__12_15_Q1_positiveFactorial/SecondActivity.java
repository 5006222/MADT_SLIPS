package com.example.slip_12_15_q1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtResult = findViewById(R.id.txtResult);

        int number = getIntent().getIntExtra("number", 0);
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        txtResult.setText("Factorial of " + number + " is: " + factorial);
    }
}
