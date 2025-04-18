package com.example.slip18_q1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView textPower, textAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textPower = findViewById(R.id.textPower);
        textAverage = findViewById(R.id.textAverage);

        double power = getIntent().getDoubleExtra("POWER", 0);
        double average = getIntent().getDoubleExtra("AVERAGE", 0);

        textPower.setText("Power: " + power);
        textAverage.setText("Average: " + average);
    }
}
