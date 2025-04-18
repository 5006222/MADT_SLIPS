package com.example.slip__16_q1_db_student;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtSurname, edtClass, edtMarks;
    RadioGroup genderGroup;
    CheckBox chkMusic, chkSports, chkArt;
    Button btnSubmit;

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurname);
        edtClass = findViewById(R.id.edtClass);
        edtMarks = findViewById(R.id.edtMarks);
        genderGroup = findViewById(R.id.genderGroup);
        chkMusic = findViewById(R.id.chkMusic);
        chkSports = findViewById(R.id.chkSports);
        chkArt = findViewById(R.id.chkArt);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String surname = edtSurname.getText().toString();
            String studentClass = edtClass.getText().toString();
            String marks = edtMarks.getText().toString();

            int selectedId = genderGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedId);
            String gender = selectedGender != null ? selectedGender.getText().toString() : "Not Selected";

            StringBuilder hobbies = new StringBuilder();
            if (chkMusic.isChecked()) hobbies.append("Music ");
            if (chkSports.isChecked()) hobbies.append("Sports ");
            if (chkArt.isChecked()) hobbies.append("Art ");

            boolean inserted = myDB.insertData(name, surname, studentClass, gender, hobbies.toString().trim(), marks);
            if (inserted) {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SecondActivity.class));
            } else {
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
