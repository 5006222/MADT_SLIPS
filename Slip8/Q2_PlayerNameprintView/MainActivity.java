package com.example.slip8_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextPoints;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextPoints = findViewById(R.id.editTextPoints);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String points = editTextPoints.getText().toString();

            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("player_name", name);
            intent.putExtra("player_points", points);
            startActivity(intent);
        });
    }
}
