package com.example.slip__16_q1_db_student;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TableLayout tableLayout;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tableLayout = findViewById(R.id.tableLayout);
        myDB = new DatabaseHelper(this);

        Cursor cursor = myDB.getAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            return;
        }

        while (cursor.moveToNext()) {
            addRow("Name", cursor.getString(1));
            addRow("Surname", cursor.getString(2));
            addRow("Class", cursor.getString(3));
            addRow("Gender", cursor.getString(4));
            addRow("Hobbies", cursor.getString(5));
            addRow("Marks", cursor.getString(6));
            addRow("——", "——");
        }
    }

    private void addRow(String label, String value) {
        TableRow row = new TableRow(this);
        TextView lbl = new TextView(this);
        lbl.setText(label);
        lbl.setPadding(10, 10, 10, 10);

        TextView val = new TextView(this);
        val.setText(value);
        val.setPadding(10, 10, 10, 10);

        row.addView(lbl);
        row.addView(val);
        tableLayout.addView(row);
    }
}
