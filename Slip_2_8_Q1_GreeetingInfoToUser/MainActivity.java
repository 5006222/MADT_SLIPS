package com.example.slip_2_8;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textViewGreeting;
    Button buttonShowGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGreeting = findViewById(R.id.textViewGreeting);
        buttonShowGreeting = findViewById(R.id.buttonShowGreeting);

        buttonShowGreeting.setOnClickListener(view -> {
            String greeting = "Hello, Tejaswini! Welcome to our app 😊";
            textViewGreeting.setText(greeting);
        });
    }
}
