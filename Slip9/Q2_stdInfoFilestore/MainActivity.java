package com.example.slip9_2;
// src/MainActivity.java


import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextRoll;
    Button buttonAdd, buttonNext;
    int studentCount = 0;
    final int MAX_STUDENTS = 10;
    final String FILE_NAME = "students.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextRoll = findViewById(R.id.editTextRoll);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonNext = findViewById(R.id.buttonNext);

        // Clear previous data
        deleteFile(FILE_NAME);

        buttonAdd.setOnClickListener(v -> {
            if (studentCount < MAX_STUDENTS) {
                String name = editTextName.getText().toString();
                String roll = editTextRoll.getText().toString();
                String entry = "Name: " + name + ", Roll: " + roll + "\n";

                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
                    fos.write(entry.getBytes());
                    fos.close();
                    Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
                    studentCount++;
                    editTextName.setText("");
                    editTextRoll.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(this, "Maximum 10 students allowed!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            startActivity(intent);
        });
    }
}
