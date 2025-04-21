package com.example.slip_q2_17_notification;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvMessage = findViewById(R.id.tvMessage);
        String msg = getIntent().getStringExtra("msg");
        tvMessage.setText(msg != null ? msg : "No message received.");
    }
}
