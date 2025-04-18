package com.example.slip_3_13_q1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewMessage = findViewById(R.id.textViewMessage);

        // Receive the message from Intent
        String message = getIntent().getStringExtra("message");
        textViewMessage.setText(message);
    }
}
