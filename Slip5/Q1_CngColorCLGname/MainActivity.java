package com.example.slip_5_q1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView collegeName;
    Button changeColorButton;
    boolean isRed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeName = findViewById(R.id.collegeName);
        changeColorButton = findViewById(R.id.btnChangeColor);

        changeColorButton.setOnClickListener(view -> {
            if (isRed) {
                collegeName.setTextColor(Color.BLUE);
            } else {
                collegeName.setTextColor(Color.RED);
            }
            isRed = !isRed;
        });
    }

}