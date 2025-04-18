package com.example.slip18_q1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNumber1, editNumber2;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber1 = findViewById(R.id.editNumber1);
        editNumber2 = findViewById(R.id.editNumber2);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            double num1 = Double.parseDouble(editNumber1.getText().toString());
            double num2 = Double.parseDouble(editNumber2.getText().toString());

            double power = Math.pow(num1, num2);
            double average = (num1 + num2) / 2;

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("POWER", power);
            intent.putExtra("AVERAGE", average);
            startActivity(intent);
        });
    }
}
