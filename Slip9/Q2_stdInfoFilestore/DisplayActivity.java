package com.example.slip9_2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.IOException;

public class DisplayActivity extends AppCompatActivity {

    TextView textViewData;
    final String FILE_NAME = "students.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewData = findViewById(R.id.textViewData);

        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            int c;
            StringBuilder data = new StringBuilder();

            while ((c = fis.read()) != -1) {
                data.append((char) c);
            }

            textViewData.setText(data.toString());
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
