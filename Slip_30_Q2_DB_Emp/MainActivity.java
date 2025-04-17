package com.example.slip30_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtEno, edtEname, edtDesignation, edtSalary;
    Button btnInsert, btnDisplay;
    TextView txtDisplay;
    EmployeeDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEno = findViewById(R.id.edtEno);
        edtEname = findViewById(R.id.edtEname);
        edtDesignation = findViewById(R.id.edtDesignation);
        edtSalary = findViewById(R.id.edtSalary);
        btnInsert = findViewById(R.id.btnInsert);
        btnDisplay = findViewById(R.id.btnDisplay);
        txtDisplay = findViewById(R.id.txtDisplay);

        dbHelper = new EmployeeDBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eno = Integer.parseInt(edtEno.getText().toString());
                String ename = edtEname.getText().toString();
                String designation = edtDesignation.getText().toString();
                double salary = Double.parseDouble(edtSalary.getText().toString());

                boolean inserted = dbHelper.insertEmployee(eno, ename, designation, salary);

                if (inserted) {
                    Toast.makeText(MainActivity.this, "Employee Added!", Toast.LENGTH_SHORT).show();
                    edtEno.setText("");
                    edtEname.setText("");
                    edtDesignation.setText("");
                    edtSalary.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Failed to Insert. Check Eno (Must be unique)!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dbHelper.getAllEmployees();
                txtDisplay.setText(data);
            }
        });
    }
}
