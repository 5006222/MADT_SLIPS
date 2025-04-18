package com.example.slip23_q1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textWelcome = findViewById(R.id.textWelcome);

        String username = getIntent().getStringExtra("username");
        textWelcome.setText("Welcome, " + username + "!");
    }
}
