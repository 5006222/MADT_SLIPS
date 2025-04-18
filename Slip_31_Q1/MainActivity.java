package com.example.slip31_q1;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch switchWifi;
    ToggleButton toggleSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchWifi = findViewById(R.id.switchWifi);
        toggleSound = findViewById(R.id.toggleSound);

        switchWifi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Wi-Fi is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Wi-Fi is OFF", Toast.LENGTH_SHORT).show();
            }
        });

        toggleSound.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Sound is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Sound is OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
