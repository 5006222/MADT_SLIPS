package com.example.slip22_q1;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupGender;
    CheckBox checkboxReading, checkboxTraveling, checkboxMusic;
    Button btnShowSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkboxReading = findViewById(R.id.checkboxReading);
        checkboxTraveling = findViewById(R.id.checkboxTraveling);
        checkboxMusic = findViewById(R.id.checkboxMusic);
        btnShowSelection = findViewById(R.id.btnShowSelection);

        btnShowSelection.setOnClickListener(v -> {
            // Get selected RadioButton
            int selectedId = radioGroupGender.getCheckedRadioButtonId();
            RadioButton selectedRadio = findViewById(selectedId);
            String gender = selectedRadio != null ? selectedRadio.getText().toString() : "None";

            // Get selected CheckBoxes
            StringBuilder hobbies = new StringBuilder();
            if (checkboxReading.isChecked()) hobbies.append("Reading ");
            if (checkboxTraveling.isChecked()) hobbies.append("Traveling ");
            if (checkboxMusic.isChecked()) hobbies.append("Music ");

            // Show result in Toast
            String result = "Gender: " + gender + "\nHobbies: " + hobbies.toString().trim();
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });
    }
}
