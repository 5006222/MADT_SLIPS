package com.example.slip8_2;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView textViewName, textViewPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewName = findViewById(R.id.textViewName);
        textViewPoints = findViewById(R.id.textViewPoints);

        String name = getIntent().getStringExtra("player_name");
        String points = getIntent().getStringExtra("player_points");

        textViewName.setText("Player Name: " + name);
        textViewPoints.setText("Points: " + points);
    }
}
