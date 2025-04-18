package com.example.slip_11_21_q1;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView txtSelectedOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RadioGroup and TextView
        radioGroup = findViewById(R.id.radioGroup);
        txtSelectedOption = findViewById(R.id.txtSelectedOption);

        // Set listener for radio group to detect selection
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // Get the selected RadioButton
            radioButton = findViewById(checkedId);
            // Display the selected option in TextView
            txtSelectedOption.setText("Selected option: " + radioButton.getText());

            // Display the selected option in Toast
            Toast.makeText(MainActivity.this, "You selected: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}
