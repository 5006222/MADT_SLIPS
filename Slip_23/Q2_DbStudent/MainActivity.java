package com.example.slip_q2_23_dbstudent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtSname, edtPhno, edtDeleteName;
    Button btnAdd, btnDelete;
    ListView listView;
    DBHelper dbHelper;
    ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSname = findViewById(R.id.edtSname);
        edtPhno = findViewById(R.id.edtPhno);
        edtDeleteName = findViewById(R.id.edtDeleteName);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        dbHelper = new DBHelper(this);
        studentList = new ArrayList<>();

        // Display all students initially
        displayStudents();

        // Add Student
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = edtSname.getText().toString();
                String phno = edtPhno.getText().toString();

                if (!sname.isEmpty() && !phno.isEmpty()) {
                    addStudent(sname, phno);
                    edtSname.setText("");
                    edtPhno.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Delete Student by Name
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteName = edtDeleteName.getText().toString();

                if (!deleteName.isEmpty()) {
                    deleteStudentByName(deleteName);
                    edtDeleteName.setText(""); // Clear the input field
                } else {
                    Toast.makeText(MainActivity.this, "Please enter the name of the student to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Add a student to the database
    private void addStudent(String sname, String phno) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_SNAME, sname);
        contentValues.put(DBHelper.COL_PHNO, phno);

        long result = db.insert(DBHelper.TABLE_NAME, null, contentValues);
        if (result != -1) {
            Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
            displayStudents(); // Refresh the list after adding
        } else {
            Toast.makeText(this, "Failed to Add Student", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete a student by name from the database
    private void deleteStudentByName(String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int result = db.delete(DBHelper.TABLE_NAME, DBHelper.COL_SNAME + " = ?", new String[]{name});

        if (result > 0) {
            Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
            displayStudents(); // Refresh the list after deletion
        } else {
            Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show();
        }
    }

    // Display all students in the ListView
    private void displayStudents() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);

        studentList.clear(); // Clear previous data
        while (cursor.moveToNext()) {
            String sid = cursor.getString(cursor.getColumnIndex(DBHelper.COL_SID));
            String sname = cursor.getString(cursor.getColumnIndex(DBHelper.COL_SNAME));
            String phno = cursor.getString(cursor.getColumnIndex(DBHelper.COL_PHNO));
            studentList.add("Sid: " + sid + " | Name: " + sname + " | Phone: " + phno);
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);
    }
}
