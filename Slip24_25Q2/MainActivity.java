package com.example.slip24_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btnShowTime;
    TextView txtSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        btnShowTime = findViewById(R.id.btnShowTime);
        txtSelectedTime = findViewById(R.id.txtSelectedTime);

        btnShowTime.setOnClickListener(view -> {
            int hour = timePicker.getHour();       // Get selected hour
            int minute = timePicker.getMinute();   // Get selected minute

            String time = String.format("Selected Time: %02d:%02d", hour, minute);
            txtSelectedTime.setText(time);
        });
    }
}
